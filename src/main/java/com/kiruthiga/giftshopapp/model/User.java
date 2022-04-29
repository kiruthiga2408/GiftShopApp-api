package com.kiruthiga.giftshopapp.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name="giftshop_users")
public class User {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="Password")
	private String password;
	
	
	@Column(name="contact_number")
	private long contactNumber;

}
