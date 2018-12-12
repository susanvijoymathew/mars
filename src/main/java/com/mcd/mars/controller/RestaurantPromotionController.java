package com.mcd.mars.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcd.mars.business.FilterForm;
import com.mcd.mars.business.PromotionForm;
import com.mcd.mars.business.RestaurantPromotion;
import com.mcd.mars.business.service.RestaurantPromotionService;
import com.mcd.mars.utility.MarsConstants;

@Controller
@RequestMapping("/mars")
public class RestaurantPromotionController {	
	private RestaurantPromotionService promotionService;
	
	@Autowired
	public RestaurantPromotionController(RestaurantPromotionService promotionService) {
		this.promotionService = promotionService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public String home(Model model) {
		this.promotionService.getAllAreas(); // Ensures AreaUtil is ready for use later.
		
		if (!model.containsAttribute("products"))
			model.addAttribute("products", promotionService.getAllProducts());
		
		if (!model.containsAttribute("locations")) {
			model.addAttribute(
				"locations",
				promotionService.getAreasOf(MarsConstants.USA, MarsConstants.COUNTRY, false));
			// Form doesn't need to show USA in the drop down menu.
		}
		
		if (!model.containsAttribute("filterForm"))
			model.addAttribute("filterForm", new FilterForm());
		
		if (!model.containsAttribute("promotionForm"))
			model.addAttribute("promotionForm", new PromotionForm());
		
		if (!model.containsAttribute("restaurantPromotionList"))
			model.addAttribute("restaurantPromotionList", promotionService.getActivePromotions());
		
		return "home";
	}
	
	@RequestMapping(value="/filter", method=RequestMethod.POST)
	public String filter(@Valid FilterForm filterForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			if (!model.containsAttribute("locations")) {
				model.addAttribute(
					"locations",
					promotionService.getAreasOf(MarsConstants.USA, MarsConstants.COUNTRY, false));
				// Form doesn't need to show USA in the drop down menu.
		}
			
			return "home";
		}
		
		Date sDate = filterForm.getStartDate();
		Date eDate = filterForm.getEndDate();
		if (sDate != null && eDate != null && eDate.before(sDate))
		{
			result.addError(new ObjectError("startDate", "Promotion start date must be before the end date."));
		}
		
		if (result.hasErrors()) {
			if (!model.containsAttribute("locations"))
				model.addAttribute("locations", promotionService.getAreasOf(MarsConstants.USA, MarsConstants.COUNTRY, false));
			
			return "home";
		}
		
		List<RestaurantPromotion> promotions = 
			promotionService.getPromotionsByFilterSelections(sDate, eDate, filterForm.getArea());

		model.addAttribute("restaurantPromotionList", promotions);
		model.addAttribute("filterForm", filterForm);
		model.addAttribute("promotionForm", new PromotionForm());
		model.addAttribute("locations", promotionService.getAreasOf(MarsConstants.USA, MarsConstants.COUNTRY, false));
		model.addAttribute("products", promotionService.getAllProducts());
		
		return "home";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@Valid PromotionForm promoForm, BindingResult result, Model model)
	{
		if (result.hasErrors()) {
			if (!model.containsAttribute("products"))
				model.addAttribute("products", promotionService.getAllProducts());
			
			if (!model.containsAttribute("locations"))
				model.addAttribute("locations", promotionService.getAreasOf(MarsConstants.USA, MarsConstants.COUNTRY, false));
			
			return "home";
		}
		
		// Validation won't allow both dates to be null.
		Date sDate = promoForm.getStartDate();
		Date eDate = promoForm.getEndDate();
		if (eDate.before(sDate)) {
			result.addError(new ObjectError("startDate", "Promotion start date must be before the end date."));
		}
		
		if (result.hasErrors()) {
			if (!model.containsAttribute("products"))
				model.addAttribute("products", promotionService.getAllProducts());
			
			if (!model.containsAttribute("locations"))
				model.addAttribute("locations", promotionService.getAreasOf(MarsConstants.USA, MarsConstants.COUNTRY, false));
			
			return "home";
		}
		
		promotionService.addPromotion(
			promoForm.getName(), promoForm.getDescription(),
			sDate, eDate, promoForm.getArea(), promoForm.getProduct());
		return "redirect:/mars";
	}
}
