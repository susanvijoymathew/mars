package com.mcd.mars.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mcd.mars.business.FilterForm;
import com.mcd.mars.business.RestaurantPromotion;
import com.mcd.mars.business.service.RestaurantPromotionService;

@Controller
@RequestMapping("/")
public class RestaurantPromotionController {
	private RestaurantPromotionService promotionService;
	
	@Autowired
	public RestaurantPromotionController(RestaurantPromotionService promotionService) {
		this.promotionService = promotionService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public String home(Model model) {
		if (!model.containsAttribute("filterForm")) {
			model.addAttribute("filterForm", new FilterForm());
			model.addAttribute("locations", promotionService.getAllAreas());
		}
		
		if (!model.containsAttribute("restaurantPromotionList"))
			model.addAttribute( promotionService.getAllPromotions() );
		
		return "home";
	}
	
	@RequestMapping(value="/filter", method=RequestMethod.POST)
	public String filter(FilterForm filterForm, RedirectAttributes model) {
		List<RestaurantPromotion> promotions = 
			promotionService.getPromotionsByFilterSelections(
				filterForm.getStartDate(), filterForm.getEndDate(), filterForm.getLocation());
		
		model.addAttribute("filterForm", filterForm);
		model.addAttribute(promotions);
		
		return "redirect:/";
	}
}