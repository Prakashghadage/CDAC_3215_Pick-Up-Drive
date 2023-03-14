package com.springDemo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
public class Location {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lid;

    @NotNull
    private String city;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<Car> car;

    public Location(String city) {
        this.city = city;
    }
}
