package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class HotelDTO implements Serializable {
	private int hotelId;
	private String hotelName;
	private  String hotelType;
	private  String location;
	private  int size;
	private String priceRange;
	

}
