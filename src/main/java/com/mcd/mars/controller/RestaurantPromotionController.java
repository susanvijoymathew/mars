package com.mcd.mars.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mcd.mars.business.FilterForm;
import com.mcd.mars.business.PromotionForm;
import com.mcd.mars.business.RestaurantPromotion;
import com.mcd.mars.business.service.RestaurantPromotionService;
import com.mcd.mars.utility.MarsDataUtility;

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
		if (!model.containsAttribute("filterForm")) {
			model.addAttribute("filterForm", new FilterForm());
			model.addAttribute("locations", promotionService.getAllAreas());
		}
		
		if (!model.containsAttribute("promotionForm")) {
			model.addAttribute("promotionForm", new PromotionForm());
			model.addAttribute("products", promotionService.getAllProducts());
		}
		
		if (!model.containsAttribute("restaurantPromotionList"))
			model.addAttribute( promotionService.getAllPromotions() );
		
		return "home";
	}
	
	@RequestMapping(value="/filter", method=RequestMethod.POST)
	public String filter(@Valid FilterForm filterForm, BindingResult result, RedirectAttributes model) {
		Date sDate = null;
		try {
			sDate = MarsDataUtility.getAsDate(filterForm.getStartDate());
		} catch(ParseException pe) {
			result.rejectValue("endDate", "Invalid date. Please enter in MM-DD-YYYY format (example, 01-20-2018).");
		}

		Date eDate = null;
		try {
			eDate = MarsDataUtility.getAsDate(filterForm.getEndDate());
		} catch(ParseException pe) {
			result.rejectValue("endDate", "Invalid date. Please enter in MM-DD-YYYY format (example, 12-03-2018).");
		}
		
		if (eDate.before(sDate)) {
			result.rejectValue("endDate", "Promotion end date must come after the promotion start date.");
		}
		
		if (result.hasErrors()) {
			model.addAttribute("FilterForm", filterForm);
			return "home";
		}
		
		List<RestaurantPromotion> promotions = 
			promotionService.getPromotionsByFilterSelections(sDate, eDate, filterForm.getLocation());
		
		model.addAttribute("filterForm", filterForm);
		model.addAttribute(promotions);
		
		return "redirect:/mars";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@Valid PromotionForm promoForm, BindingResult result, Model model) {
		Date sDate = null;
		try {
			sDate = MarsDataUtility.getAsDate(promoForm.getStartDate());
		} catch(ParseException pe) {
			result.rejectValue("endDate", "Invalid date. Please enter in MM-DD-YYYY format (example, 01-20-2018).");
		}

		Date eDate = null;
		try {
			eDate = MarsDataUtility.getAsDate(promoForm.getEndDate());
		} catch(ParseException pe) {
			result.rejectValue("endDate", "Invalid date. Please enter in MM-DD-YYYY format (example, 12-03-2018).");
		}
		
		if (eDate.before(sDate)) {
			result.rejectValue("endDate", "Promotion end date must come after the promotion start date.");;
		}
		
		if (result.hasErrors()) {
			model.addAttribute("PromotionForm", promoForm);
			return "home";
		}
		
		promotionService.addPromotion(
			promoForm.getName(), promoForm.getDescription(),
			sDate, eDate,
			promoForm.getArea(), promoForm.getProduct());
		return "redirect:/mars";
	}
}
