package com.springDemo.RequestDtos;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarRequestDto implements Serializable{

//	@NotBlank
    private String brand;
//    @NotBlank
    private String model;
//    @NotBlank
    private String category;
//    @NotNull
//    @Min(2004)
    private long productionYear;
//    @NotBlank
    private String color;
//    @NotBlank
    private String city;
//    @NotNull
//    @Min(100)
    private double rate;
//    @NotBlank
    private String image;
	
}
