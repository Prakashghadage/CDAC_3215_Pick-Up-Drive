package com.springDemo.entities;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Car {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="car_id")
    private long cid;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    @Enumerated(EnumType.STRING)
    private com.springDemo.entities.Category category;
    @NotNull
    private long productionYear;
    @NotNull
    private String color;
    @NotNull
    private double rate;
    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<Reservation> reservation;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private Location location;
    @NotNull
    private String image;

    

}
