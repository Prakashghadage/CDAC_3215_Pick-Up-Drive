package com.springDemo.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rent_id")
    private Long rid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "carid", nullable = false)
    private Car car;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "date")
    @Column(name = "start_Date")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "date")
    @Column(name="end_Date")
    private Date endDate;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "pickup_Location")
    private Location pickupLocation;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "drop_Location")
    private Location dropLocation;

    private double amount;

	public Reservation(Car car, User user, Date startDate, Date endDate, Location pickupLocation,
			Location dropLocation, double amount) {
		super();
		this.car = car;
		this.user = user;
		this.startDate= startDate;
		this.endDate = endDate;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.amount = amount;
	}
}
