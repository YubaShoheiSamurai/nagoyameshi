package com.example.nagoyameshi.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.Review;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.ReviewForm;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.ReviewRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
	private final ReviewRepository reviewRepository;
	private final RestaurantRepository restaurantRepository;
	private final ReviewService reviewService;

	public ReviewController(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository,
			ReviewService reviewServic) {
		this.reviewRepository = reviewRepository;
		this.restaurantRepository = restaurantRepository;
		this.reviewService = reviewServic;
	}

	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer restaurantId,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, RedirectAttributes redirectAttributes,
			Model model) {
		User user = userDetailsImpl.getUser();
		if ("ROLE_FREE_MEMBER".equals(user.getRole().getName())) {
			redirectAttributes.addFlashAttribute("subscriptionMessage", "この機能は有料プランに加入しないと使用できません");
			return "redirect:/subscription/register";
		}
		Restaurant restaurant = restaurantRepository.getReferenceById(restaurantId);
		List<Review> reviews = reviewRepository.findByRestaurantIdAndUserId(restaurantId, user.getId());
		ReviewForm reviewForm = new ReviewForm();
		if (reviews.size() > 0) {
			reviewForm.setId(reviews.get(0).getId());
			reviewForm.setReview(reviews.get(0).getReview());
			reviewForm.setComment(reviews.get(0).getComment());
		}

		model.addAttribute("reviewForm", reviewForm);
		model.addAttribute("restaurant", restaurant);
		return "reviews/show";
	}

	@PostMapping("/{restaurantId}/update")
	public String update(Model model, @PathVariable(name = "restaurantId") Integer restaurantId,
			@ModelAttribute @Validated ReviewForm reviewForm,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		Restaurant restaurant = restaurantRepository.getReferenceById(restaurantId);
		User user = userDetailsImpl.getUser();
		if (bindingResult.hasErrors()) {

			model.addAttribute("reviewForm", reviewForm);
			model.addAttribute("restaurant", restaurant);
			return "reviews/show";
		}
		reviewService.createOrUpdate(reviewForm, restaurant, user);
		if (reviewForm.getId() == null) {
			redirectAttributes.addFlashAttribute("successMessage", "レビューを投稿しました。");
		} else {
			redirectAttributes.addFlashAttribute("successMessage", "レビューを編集しました。");
		}
		return "redirect:/restaurants/" + restaurantId;
	}
}
