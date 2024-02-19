package com.example.nagoyameshi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Category;
import com.example.nagoyameshi.entity.Regular;
import com.example.nagoyameshi.entity.Restaurant;
import com.example.nagoyameshi.entity.RestaurantCategory;
import com.example.nagoyameshi.form.RestaurantEditForm;
import com.example.nagoyameshi.form.RestaurantRegisterForm;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.service.RegularService;
import com.example.nagoyameshi.service.RestaurantCategoryService;
import com.example.nagoyameshi.service.RestaurantService;

@Controller
@RequestMapping("/admin/restaurants")
public class AdminRestaurantController {
	private final RestaurantRepository restaurantRepository;
	private final CategoryRepository categoryRepository;
	private final RestaurantService restaurantService;
	private final RestaurantCategoryService restaurantCategoryService;
	private final RegularService regularService;

	public AdminRestaurantController(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository,
			RestaurantService restaurantService, RestaurantCategoryService restaurantCategoryService, RegularService regularService) {
		this.restaurantRepository = restaurantRepository;
		this.categoryRepository = categoryRepository;
		this.restaurantService = restaurantService;
		this.restaurantCategoryService = restaurantCategoryService;
		this.regularService = regularService;
	}

	@GetMapping
	public String index(Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			@RequestParam(name = "keyword", required = false) String keyword) {
		Page<Restaurant> restaurantPage;
		if (keyword != null && !keyword.isEmpty()) {
			restaurantPage = restaurantRepository.findByNameLike("%" + keyword + "%", pageable);
		} else {
			restaurantPage = restaurantRepository.findAll(pageable);
		}

		model.addAttribute("restaurantPage", restaurantPage);
		model.addAttribute("keyword", keyword);

		return "admin/restaurants/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);

		model.addAttribute("restaurant", restaurant);

		return "admin/restaurants/show";
	}

	@GetMapping("/register")
	public String register(Model model) {
		List<Category> categories = categoryRepository.findAll();
		List<String> regulars = new ArrayList<String>(Arrays.asList("日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日"));
		model.addAttribute("restaurantRegisterForm", new RestaurantRegisterForm());
		model.addAttribute("categoryOptions", categories);
		model.addAttribute("regularsOptions", regulars);
		return "admin/restaurants/register";
	}

	@PostMapping("/create")
	public String create(Model model, @ModelAttribute @Validated RestaurantRegisterForm restaurantRegisterForm,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("restaurant", restaurantRegisterForm);
			return "admin/restaurants/register";
		}
		Restaurant restaurant = restaurantService.create(restaurantRegisterForm);
		for (Integer categoryId : restaurantRegisterForm.getCategories()) {
			restaurantCategoryService.create(restaurant.getId(), categoryId);
		}
		for (Integer holiday : restaurantRegisterForm.getRegulars()) {
			regularService.create(restaurant.getId(), holiday);
		}
		redirectAttributes.addFlashAttribute("successMessage", "店舗情報を登録しました。");

		return "redirect:/admin/restaurants";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		String imageName = restaurant.getImageName();
		List<Integer> categoryList = new ArrayList<Integer>();
		for (Category category : restaurant.getCategories()) {
			categoryList.add(category.getId());
		}
		List<Integer> regularList = new ArrayList<Integer>();
		for (Regular regular : restaurant.getRegulars()) {
			regularList.add(regular.getHoliday());
		}
		RestaurantEditForm restaurantEditForm = new RestaurantEditForm(restaurant.getId(), restaurant.getName(), null,
				restaurant.getDescription(), restaurant.getLowPrice(), restaurant.getHighPrice(),
				restaurant.getPostalCode(), restaurant.getAddress(), restaurant.getOpeningTime(),
				restaurant.getClosedTime(), regularList.toArray(new Integer[regularList.size()]), restaurant.getSeatingCapacity(),
				categoryList.toArray(new Integer[categoryList.size()]));
		List<Category> categories = categoryRepository.findAll();
		List<String> regulars = new ArrayList<String>(Arrays.asList("日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日"));
		model.addAttribute("imageName", imageName);
		model.addAttribute("categoryOptions", categories);
		model.addAttribute("regularsOptions", regulars);
		model.addAttribute("restaurantEditForm", restaurantEditForm);

		return "admin/restaurants/edit";
	}

	@PostMapping("/{id}/update")
	public String update(@ModelAttribute @Validated RestaurantEditForm restaurantEditForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "admin/restaurants/edit";
		}

		restaurantService.update(restaurantEditForm);
		
		List<RestaurantCategory> restaurantCategories = restaurantCategoryService.selectByRestaurantId(restaurantEditForm.getId());
		restaurantCategoryService.delete(restaurantCategories);
		for (Integer categoryId : restaurantEditForm.getCategories()) {
			restaurantCategoryService.create(restaurantEditForm.getId(), categoryId);
		}
		List<Regular> regulars = regularService.selectByRestaurantId(restaurantEditForm.getId());
		regularService.delete(regulars);
		for (Integer holiday : restaurantEditForm.getRegulars()) {
			regularService.create(restaurantEditForm.getId(), holiday);
		}
		redirectAttributes.addFlashAttribute("successMessage", "店舗情報を編集しました。");

		return "redirect:/admin/restaurants";
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
		restaurantRepository.deleteById(id);

		redirectAttributes.addFlashAttribute("successMessage", "店舗情報を削除しました。");

		return "redirect:/admin/restaurants";
	}
}
