package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Regular;

public interface RegularRepository extends JpaRepository<Regular, Integer>{
	public List<Regular> findByRestaurantId(Integer restaurantId);
}
