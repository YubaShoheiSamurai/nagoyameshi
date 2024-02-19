package com.example.nagoyameshi.entity;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
	private int highPrice;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "address")
	private String address;

	@Column(name = "opening_time")
	private LocalTime openingTime;

	@Column(name = "closed_time")
	private LocalTime closedTime;

	@Column(name = "seating_capacity")
	private int seatingCapacity;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@PrePersist
	public void onPrePersist() {
		setCreatedAt(new Timestamp(System.currentTimeMillis()));
		setUpdatedAt(new Timestamp(System.currentTimeMillis()));
	}

	@PreUpdate
	public void onPreUpdate() {
		setUpdatedAt(new Timestamp(System.currentTimeMillis()));
	}

	@ManyToMany
	@JoinTable(name = "restaurant_category", joinColumns = @JoinColumn(name = "restaurant_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	private List<Category> categories = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "favarites", joinColumns = @JoinColumn(name = "restaurant_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	private List<User> favariteUsers = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "restaurant_id")
    private List<Regular> regulars = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "restaurant_id")
    private List<Review> reviews = new ArrayList<>();
	
	public double getReviewAvg() {
		return reviews.stream().mapToInt(r -> r.getReview()).average().orElse(0);
	}
}
