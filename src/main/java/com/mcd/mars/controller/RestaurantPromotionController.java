package com.mcd.mars.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcd.mars.business.FilterForm;
import com.mcd.mars.business.PromotionForm;
import com.mcd.mars.business.RestaurantPromotion;
import com.mcd.mars.business.service.RestaurantPromotionService;
import com.mcd.mars.data.entity.Promotion;
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
			model.addAttribute("locations", promotionService.getAreasOfUSA(false));
			// Form doesn't need to show USA in the drop down menu.
		}
		
		if (!model.containsAttribute("filterForm"))
			model.addAttribute("filterForm", new FilterForm());
		
		if (!model.containsAttribute("promotionForm"))
			model.addAttribute("promotionForm", new PromotionForm());
		
		if (!model.containsAttribute("restaurantPromotionList"))
			model.addAttribute("restaurantPromotionList", promotionService.getActivePromotions());
		
		return MarsConstants.MARS_HOME_VIEW;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@Valid PromotionForm promoForm, BindingResult result, Model model) {
		// Will need the following attributes in the model whether the form has error or not.
		model.addAttribute("filterForm", new FilterForm());
		model.addAttribute("products", promotionService.getAllProducts());
		model.addAttribute("locations", promotionService.getAreasOfUSA(false));
		
		if (result.hasErrors())
			return MarsConstants.MARS_HOME_VIEW;
		
		// Validation won't allow both dates to be null.
		Date sDate = promoForm.getStartDate();
		Date eDate = promoForm.getEndDate();
		if (eDate.before(sDate)) {
			result.addError(new ObjectError("startDate", "Promotion start date must be before the end date."));
		}
		
		if (result.hasErrors())
			return MarsConstants.MARS_HOME_VIEW;
		
		promotionService.addPromotion(promoForm);
		return MarsConstants.MARS_HOME_REDIRECT_URL;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		PromotionForm promotionForm = new PromotionForm();
		initializePromotionForm(promotionForm, promotionService.getPromotion(id));
		
		model.addAttribute("products", promotionService.getAllProducts());
		model.addAttribute("locations", promotionService.getAreasOfUSA(false));
		model.addAttribute("promotionForm", promotionForm);
		
		return MarsConstants.MARS_EDIT_VIEW;
	}
	
	@RequestMapping(value="/filter", method=RequestMethod.POST)
	public String filter(@Valid FilterForm filterForm, BindingResult result, Model model) {
		// Will need the following attributes in the model whether the form has error or not.
		model.addAttribute("promotionForm", new PromotionForm());
		model.addAttribute("locations", promotionService.getAreasOfUSA(false));
		model.addAttribute("products", promotionService.getAllProducts());
		
		if (result.hasErrors())
			return MarsConstants.MARS_HOME_VIEW;
		
		Date sDate = filterForm.getStartDate();
		Date eDate = filterForm.getEndDate();
		if (sDate != null && eDate != null && eDate.before(sDate)) {
			result.addError(new ObjectError("startDate", "Promotion start date must be before the end date."));
		}
		
		if (result.hasErrors())
			return MarsConstants.MARS_HOME_VIEW;
		
		List<RestaurantPromotion> promotions = 
			promotionService.getPromotionsByFilterSelections(sDate, eDate, filterForm.getArea());

		model.addAttribute("restaurantPromotionList", promotions);
		model.addAttribute("filterForm", filterForm); // Add the current filter form to the model
		
		return MarsConstants.MARS_HOME_VIEW;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@Valid PromotionForm promoForm, BindingResult result, Model model) {
		// Will need the following attributes in the model whether the form has error or not.
		model.addAttribute("products", promotionService.getAllProducts());
		model.addAttribute("locations", promotionService.getAreasOfUSA(false));
		
		if (result.hasErrors())
			return MarsConstants.MARS_EDIT_VIEW;
		
		// Validation won't allow both dates to be null.
		Date sDate = promoForm.getStartDate();
		Date eDate = promoForm.getEndDate();
		if (eDate.before(sDate)) {
			result.addError(new ObjectError("startDate", "Promotion start date must be before the end date."));
		}
		
		if (result.hasErrors())
			return MarsConstants.MARS_EDIT_VIEW;
		
		promotionService.updatePromotion(promoForm);
		return MarsConstants.MARS_HOME_REDIRECT_URL;
	}
	
	private void initializePromotionForm(PromotionForm form, Promotion p) {
		form.setId(p.getId());
		form.setName(p.getName());
		form.setDescription(p.getDescription());
		form.setStartDate(p.getStartDate());
		form.setEndDate(p.getEndDate());
		form.setArea(p.getAreaId());
		form.setProduct(p.getProductId());
	}
}
