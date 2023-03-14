package com.springDemo.RequestDtos;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReservationReqDto implements Serializable {

	    @NotBlank
	    @Min(1)
//	    @JsonProperty("uid")
	    private long uid;
	    
	    @NotBlank
	    @Min(1)
//	    @JsonProperty("cid")
	    private long cid;
	    @NotBlank
//	    @JsonProperty("end_Date")
	    private String endDate;
	    @NotBlank
//	    @JsonProperty("start_Date")
	    private String startDate;
	    
	    @NotBlank
//	    @JsonProperty("drop_Location")
	    private String dropLocation;
	    
	    @NotBlank
//	    @JsonProperty("pickup_Location")
	    private String pickupLocation;
	
}
