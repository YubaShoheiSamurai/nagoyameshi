package com.example.nagoyameshi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.RestaurantCategory;
import com.example.nagoyameshi.repository.RestaurantCategoryRepository;

@Service
public class RestaurantCategoryService {
	private final RestaurantCategoryRepository restaurantCategoryRepository;    
    
    public RestaurantCategoryService(RestaurantCategoryRepository restaurantCategoryRepository) {
        this.restaurantCategoryRepository = restaurantCategoryRepository;        
    }
    
    public List<RestaurantCategory> selectByRestaurantId(Integer restaurantId) {
    	return restaurantCategoryRepository.findByRestaurantId(restaurantId);
    }
    
    @Transactional
    public void create(Integer restaurantId, Integer categoryId) {
        RestaurantCategory restaurantCategory = new RestaurantCategory();        
        restaurantCategory.setRestaurantId(restaurantId);                
        restaurantCategory.setCategoryId(categoryId);
        restaurantCategoryRepository.save(restaurantCategory);
    }
    
    @Transactional
    public void delete(List<RestaurantCategory> restaurantCategories) {
        restaurantCategoryRepository.deleteAll(restaurantCategories);
    }
}
