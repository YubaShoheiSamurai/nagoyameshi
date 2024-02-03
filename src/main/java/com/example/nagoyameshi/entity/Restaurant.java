package com.example.nagoyameshi.entity;

import java.sql.Time;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image_name")
    private String imageName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "low_price")
	private int lowPrice;
	
	@Column(name = "high_price")
	private int highrice;
	
	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "address")
	private String address;
	
	@Column(name = "opening_time")
	private Time openingTime;
	
	@Column(name = "closed_time")
	private Time closedTime;

	@Column(name = "seating_capacity")
	private int seatingCapacity;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;
}
