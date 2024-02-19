package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	public Page<Restaurant> findByNameLike(String keyword, Pageable pageable);
	
	public Page<Restaurant> findByNameLikeOrAddressLikeOrCategoriesNameLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword, String categoryKeyword, Pageable pageable);  
    public Page<Restaurant> findByNameLikeOrAddressLikeOrCategoriesNameLikeOrderByLowPriceAsc(String nameKeyword, String addressKeyword, String categoryKeyword, Pageable pageable); 
    public Page<Restaurant> findByLowPriceLessThanEqualOrderByCreatedAtDesc(Integer price, Pageable pageable);
    public Page<Restaurant> findByLowPriceLessThanEqualOrderByLowPriceAsc(Integer price, Pageable pageable); 
    public Page<Restaurant> findByCategoriesIdOrderByCreatedAtDesc(Integer category, Pageable pageable);
    public Page<Restaurant> findByCategoriesIdOrderByLowPriceAsc(Integer category, Pageable pageable); 
    public Page<Restaurant> findAllByOrderByCreatedAtDesc(Pageable pageable);
    public Page<Restaurant> findAllByOrderByLowPriceAsc(Pageable pageable);
    
    public Page<Restaurant> findByFavariteUsersId(Integer userId, Pageable pageable);
    
    public List<Restaurant> findTop10ByOrderByCreatedAtDesc();
}
