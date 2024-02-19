package com.example.nagoyameshi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Category;
import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReservationInputForm;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	private final RestaurantRepository restaurantRepository;
	private final CategoryRepository categoryRepository;
	private final ReviewRepository reviewRepository;

	public RestaurantController(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository,
			ReviewRepository reviewRepository) {
		this.restaurantRepository = restaurantRepository;
		this.categoryRepository = categoryRepository;
		this.reviewRepository = reviewRepository;
	}

	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "price", required = false) Integer price,
			@RequestParam(name = "category", required = false) Integer category,
			@RequestParam(name = "order", required = false) String order,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {
		Page<Restaurant> restaurantPage;

		if (keyword != null && !keyword.isEmpty()) {
			if (order != null && order.equals("priceAsc")) {
				restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrCategoriesNameLikeOrderByLowPriceAsc(
						"%" + keyword + "%",
						"%" + keyword + "%", "%" + keyword + "%", pageable);
			} else {
				restaurantPage = restaurantRepository
						.findByNameLikeOrAddressLikeOrCategoriesNameLikeOrderByCreatedAtDesc(
								"%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%", pageable);
			}
		} else if (price != null) {
			if (order != null && order.equals("priceAsc")) {
				restaurantPage = restaurantRepository.findByLowPriceLessThanEqualOrderByLowPriceAsc(price, pageable);
			} else {
				restaurantPage = restaurantRepository.findByLowPriceLessThanEqualOrderByCreatedAtDesc(price, pageable);
			}
		} else if (category != null) {
			if (order != null && order.equals("priceAsc")) {
				restaurantPage = restaurantRepository.findByCategoriesIdOrderByLowPriceAsc(category, pageable);
			} else {
				restaurantPage = restaurantRepository.findByCategoriesIdOrderByCreatedAtDesc(category, pageable);
			}
		} else {
			if (order != null && order.equals("priceAsc")) {
				restaurantPage = restaurantRepository.findAllByOrderByLowPriceAsc(pageable);
			} else {
				restaurantPage = restaurantRepository.findAllByOrderByCreatedAtDesc(pageable);
			}
		}
		List<Category> categories = categoryRepository.findAll();
		

		model.addAttribute("restaurantPage", restaurantPage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("price", price);
		model.addAttribute("order", order);
		model.addAttribute("category", category);
		model.addAttribute("categories", categories);

		return "restaurants/index";
	}

	@GetMapping("/{id}")
	public String show(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PathVariable(name = "id") Integer id,
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		Page<Review> reviewPage = reviewRepository.findByRestaurantIdOrderByReviewDescCreatedAtDesc(id, pageable);
		boolean favariteFlg = false;
		if (userDetailsImpl != null) {
			User user = userDetailsImpl.getUser();
			favariteFlg = restaurant.getFavariteUsers().stream().filter(u -> u.getId().equals(user.getId()))
					.count() >= 1 ? true : false;
		}

		model.addAttribute("restaurant", restaurant);
		model.addAttribute("reservationInputForm", new ReservationInputForm());
		model.addAttribute("favariteFlg", favariteFlg);
		model.addAttribute("reviewPage", reviewPage);

		return "restaurants/show";
	}
}
