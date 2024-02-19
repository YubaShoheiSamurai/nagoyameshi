package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
    public Page<Review> findByRestaurantIdOrderByReviewDescCreatedAtDesc(Integer restaurantId, Pageable pageable);
    public List<Review> findByRestaurantIdAndUserId(Integer restaurantId,Integer user);
}
