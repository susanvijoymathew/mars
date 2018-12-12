package com.mcd.mars.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mcd.mars.business.RestaurantPromotion;
import com.mcd.mars.data.entity.Area;
import com.mcd.mars.data.entity.Product;
import com.mcd.mars.data.entity.Promotion;
import com.mcd.mars.data.entity.Role;
import com.mcd.mars.data.entity.User;
import com.mcd.mars.data.repository.AreaRepository;
import com.mcd.mars.data.repository.ProductRepository;
import com.mcd.mars.data.repository.PromotionRepository;
import com.mcd.mars.data.repository.RoleRepository;
import com.mcd.mars.data.repository.UserRepository;
import com.mcd.mars.utility.AreaUtil;

@Service
public class RestaurantPromotionService {

	private AreaRepository areaRepository;
	private RoleRepository roleRepository;
	private ProductRepository productRepository;
	private PromotionRepository promotionRepository;
	private UserRepository userRepository;
	
	@Autowired
	public RestaurantPromotionService(
		AreaRepository areas, RoleRepository roles,
		ProductRepository products, PromotionRepository promotions,
		UserRepository users)
	{
		this.areaRepository = areas;
		this.roleRepository = roles;
		this.productRepository = products;
		this.promotionRepository = promotions;
		this.userRepository = users;
	}
	
	// When cache is updated or invalidated, ensure map in AreaUtil is updated
	@Cacheable("mars_areas")
	public List<Area> getAllAreas() {
		return areaRepository.findAll();
	}
	
	public List<Area> getAreasOf(String name, String type, boolean includeSearchArea) {
		return AreaUtil.getAreasOf(name, type, includeSearchArea, this.getAllAreas()); 
	}
	
	@Cacheable("mars_products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public void addPromotion(String name, String description, Date startDate, Date endDate, long area, long product) {
		Promotion p = new Promotion();
		
		p.setAreaId(area);
		p.setProductId(product);
		p.setName(name);
		p.setDescription(description);
		p.setStartDate(startDate);
		p.setEndDate(endDate);
		p.setModifiedDate(new Date());
		p.setModifiedUserId(1); // hard coded for now
		
		promotionRepository.save(p);
	}
	
	public List<RestaurantPromotion> getActivePromotions() {
		List<RestaurantPromotion> usPromos = new ArrayList<RestaurantPromotion> ();
		List<Promotion> promotions = promotionRepository.findAllActivePromotions();
		
		for (Promotion promo: promotions) {
			RestaurantPromotion rp = new RestaurantPromotion();
			//TODO: determine if this promotion is active.
			rp.setPromotion(promo);
			rp.setArea( areaRepository.findById(promo.getAreaId()) );
			rp.setProduct( productRepository.findById(promo.getProductId()) );
			rp.setUser( userRepository.findById(promo.getModifiedUserId()) );
			rp.setRole( roleRepository.findById( rp.getUser().getRoleId()) );
			
			usPromos.add(rp);
		}
		
		return usPromos;
	}
	
	public List<RestaurantPromotion> getAllPromotions() {
		List<RestaurantPromotion> usPromos = new ArrayList<RestaurantPromotion> ();
		
		for (Promotion promo: promotionRepository.findAll()) {
			RestaurantPromotion rp = new RestaurantPromotion();
			
			rp.setPromotion(promo);
			rp.setArea( areaRepository.findById(promo.getAreaId()) );
			rp.setProduct( productRepository.findById(promo.getProductId()) );
			rp.setUser( userRepository.findById(promo.getModifiedUserId()) );
			rp.setRole( roleRepository.findById( rp.getUser().getRoleId()) );
			
			usPromos.add(rp);
		}
		
		return usPromos;
	}
	
	public List<RestaurantPromotion> getPromotionsByFilterSelections(Date startDate, Date endDate, long areaId) {
		List<RestaurantPromotion> usPromos = new ArrayList<RestaurantPromotion> ();
		
		// If area is not selected, then all promotions that match the date filter should be shown.
		// Else, we have to include promotions that belong to the areas under the selected area.
		List<Area> searchAreas =
			(areaId <= 0) ?
				null :
				AreaUtil.getAreasOf(areaId, true, this.getAllAreas());
		
		// This should not happen but just in case.
		if (areaId > 0 && searchAreas == null)
			return usPromos; // return empty list
		
		
		List<Promotion> promotions = null;
		if (startDate != null && endDate != null) {
			promotions = promotionRepository.findByStartAndEndDates(startDate, endDate);
		} else if (startDate != null) {
			promotions = promotionRepository.findByStartDateGreaterThanEqual(startDate);
		} else if (endDate != null) {
			promotions = promotionRepository.findByEndDateLessThanEqual(endDate);
		} else {
			promotions = promotionRepository.findAll();
		}
		
		for (Promotion promo: promotions) {
			Area area = areaRepository.findById(promo.getAreaId());
			if (areaId > 0 && !searchAreas.contains(area))
				continue;
			
			RestaurantPromotion rp = new RestaurantPromotion();
			
			rp.setPromotion(promo);
			rp.setArea( area );
			rp.setProduct( productRepository.findById(promo.getProductId()) );
			rp.setUser( userRepository.findById(promo.getModifiedUserId()) );
			rp.setRole( roleRepository.findById( rp.getUser().getRoleId()) );
			
			usPromos.add(rp);
		}
		
		return usPromos;
	}
	
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
