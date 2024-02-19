package com.example.nagoyameshi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.FavariteService;

@Controller
@RequestMapping("/favarites")
public class FavaritesController {
	private final RestaurantRepository restaurantRepository;
	private final FavariteService favariteService;

	public FavaritesController(RestaurantRepository restaurantRepository, FavariteService favariteService) {
		this.restaurantRepository = restaurantRepository;
		this.favariteService = favariteService;
	}

	@GetMapping
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {

		User user = userDetailsImpl.getUser();
		Page<Restaurant> restaurantPage = restaurantRepository.findByFavariteUsersId(user.getId(), pageable);

		model.addAttribute("restaurantPage", restaurantPage);

		return "favarites/index";
	}

	@PostMapping("/{restaurantId}/{favariteFlg}")
	public String update(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,@PathVariable(name = "restaurantId") Integer restaurantId, @PathVariable(name = "favariteFlg") Boolean favariteFlg,
			RedirectAttributes redirectAttributes) {
		
		User user = userDetailsImpl.getUser();
		Restaurant restaurant = restaurantRepository.getReferenceById(restaurantId);
		if (!favariteFlg) {
			favariteService.create(user, restaurant);
			redirectAttributes.addFlashAttribute("successMessage", "お気に入り登録しました。");	
		} else {
			favariteService.delete(user, restaurant);
			redirectAttributes.addFlashAttribute("successMessage", "お気に入りを解除しました。");
		}
		return "redirect:/restaurants/" + restaurant.getId();
	}
}
