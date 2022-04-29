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
@Entity(name="giftshop_items")
public class Items {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column(name="id")
	private Integer id;
	
	@Column(name="gift_id")
	private Integer giftItemId;
	
	@Column(name="gift_name")
	private String giftName;
	
	@Column(name="gift_price")
	private Integer giftPrice;

}
