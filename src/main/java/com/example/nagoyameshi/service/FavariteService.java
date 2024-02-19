package com.example.nagoyameshi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Favarite;
import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.FavariteRepository;

@Service
public class FavariteService {
	private final FavariteRepository favariteRepository;    
    
    public FavariteService(FavariteRepository favariteRepository) {
        this.favariteRepository = favariteRepository;        
    }    
    
    @Transactional
    public void create(User user, Restaurant restaurant) {
    	Favarite favarite = new Favarite();
		favarite.setUser(user);
		favarite.setRestaurant(restaurant);
		favariteRepository.save(favarite);
    }
    
    @Transactional
    public void delete(User user, Restaurant restaurant) {
    	List<Favarite> favarites = favariteRepository.findByUserIdAndRestaurantIdOrderByCreatedAtDesc(user.getId(), restaurant.getId());
                    
    	favariteRepository.deleteAll(favarites);
    } 
}
