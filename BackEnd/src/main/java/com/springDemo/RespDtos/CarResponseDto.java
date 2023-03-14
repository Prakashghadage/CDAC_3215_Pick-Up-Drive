package com.springDemo.RespDtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springDemo.entities.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarResponseDto implements Serializable{

	 private long cid;
	 
	    private String brand;
	    
	    private String model;
	    
	    private String category;
	    
	    private long productionYear;
	    
	    private String color;
	   
	    private double rate;
	   
	    private String image;
	   
	    @JsonIgnore
	    private Location location;
	
}
