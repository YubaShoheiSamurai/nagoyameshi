package com.example.nagoyameshi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Regular;
import com.example.nagoyameshi.repository.RegularRepository;

@Service
public class RegularService {
	private final RegularRepository regularRepository;    
    
    public RegularService(RegularRepository regularRepository) {
        this.regularRepository = regularRepository;        
    }
    
    public List<Regular> selectByRestaurantId(Integer restaurantId) {
    	return regularRepository.findByRestaurantId(restaurantId);
    }
    
    @Transactional
    public void create(Integer restaurantId, Integer holiday) {
    	Regular regular = new Regular();        
    	regular.setRestaurantId(restaurantId);                
    	regular.setHoliday(holiday);
    	regularRepository.save(regular);
    }
    
    @Transactional
    public void delete(List<Regular> regulars) {
    	regularRepository.deleteAll(regulars);
    }
}
