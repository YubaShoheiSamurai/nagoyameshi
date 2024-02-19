package com.example.nagoyameshi.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurant_category")
@Data
public class RestaurantCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "restaurant_id")
	private Integer restaurantId;

	@Column(name = "category_id")
	private Integer categoryId;

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
}
