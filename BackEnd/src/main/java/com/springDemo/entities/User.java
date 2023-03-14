package com.springDemo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long uid;
	
	@NotBlank
	@Size(max=20)
	private String username;
	
	@NotBlank
	@Size(max=60)
	@Email(message = "Email is not valid")
	private String email;
	
	@NotBlank
	@Size(max=10)
	private String password;
	
    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();
   

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 60) @Email String email,
			@NotBlank @Size(max = 10) String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	 public void setReservations(Reservation reservations) {
	        this.reservations.add(reservations);
	    }
	
	
}
