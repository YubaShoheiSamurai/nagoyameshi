package com.example.nagoyameshi.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.nagoyameshi.entity.Category;
import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.Revenue;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.StripeService;
import com.stripe.exception.StripeException;

@Controller
public class HomeController {
	private final RestaurantRepository restaurantRepository;
	private final CategoryRepository categoryRepository;
	private final StripeService stripeService;

	public HomeController(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository, StripeService stripeService) {
		this.restaurantRepository = restaurantRepository;
		this.categoryRepository = categoryRepository;
		this.stripeService = stripeService;
	}

	@GetMapping("/")
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) throws StripeException {
		if (userDetailsImpl != null && "ROLE_ADMIN".equals(userDetailsImpl.getUser().getRole().getName())) {
			
			LocalDate thisMonth = LocalDate.now();
			LocalDate startMonth = thisMonth.minusMonths(11);
			List<Revenue> totalRevenues = stripeService.getTotalRevenueByPeriod(startMonth, thisMonth);
			model.addAttribute("totalRevenues", totalRevenues);
			return "admin/index";
		}
		List<Restaurant> newRestaurants = restaurantRepository.findTop10ByOrderByCreatedAtDesc();
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("newRestaurants", newRestaurants);
		model.addAttribute("categories", categories);

		return "index";
	}
}
