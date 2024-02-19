package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReviewForm;
import com.example.nagoyameshi.repository.ReviewRepository;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;
    
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }    
    
    @Transactional
    public void createOrUpdate(ReviewForm reviewForm, Restaurant restaurant, User user) {
    	Review review = new Review();
    	if (reviewForm.getId() != null) {
    		review = reviewRepository.getReferenceById(reviewForm.getId());
    	}
        review.setRestaurant(restaurant);
        review.setUser(user);
        review.setReview(reviewForm.getReview());
        review.setComment(reviewForm.getComment());
        reviewRepository.save(review);
    }
}
