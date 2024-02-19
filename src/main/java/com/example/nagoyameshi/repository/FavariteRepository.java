package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Favarite;

public interface FavariteRepository extends JpaRepository<Favarite, Integer> {
	public List<Favarite> findByUserIdAndRestaurantIdOrderByCreatedAtDesc(Integer userId, Integer restaurantId);
}
