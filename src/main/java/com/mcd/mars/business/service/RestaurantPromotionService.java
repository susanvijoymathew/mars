package com.mcd.mars.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		//createAreaMap(this.getAllAreas());
	}
	
	// When cache is updated or invalidated, ensure map in AreaUtil is updated
	@Cacheable("areas")
	public List<Area> getAllAreas() {
		return areaRepository.findAll();
	}
	
	public List<Area> getAllAreasFor(Area location) {
		List<Area> results = new ArrayList<Area>();
		List<Area> allAreas = this.getAllAreas();
//TODO: cull for specific area
		return results;
	}
	
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
	
	public List<RestaurantPromotion> getAllActivePromotions() {
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
		List<Promotion> promotions = promotionRepository.findAll();
		
		for (Promotion promo: promotions) {
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
		/*List<Area> areas = AreaCache.getInstance().getAllAreas();
		for (Area a: areas)
		System.out.println(a);*/
		
		List<Promotion> promotions = null;
		if (startDate != null && endDate != null) {
			promotions = promotionRepository.findByStartAndEndDates(startDate, endDate);
		} else if (startDate != null) {
			promotions = promotionRepository.findByStartDateGreaterThanEqual(startDate);
		} else if (endDate != null) {
			promotions = promotionRepository.findByEndDateLessThanEqual(endDate);
		} else {
			promotions = promotionRepository.findAllActivePromotions();
		}
		
		for (Promotion promo: promotions) {
			Area area = areaRepository.findById(promo.getAreaId());
			
			//If area selected is a state, then all cities of this state that come up in the promotion list
			//should be chosen for display.
			
			//if (areaName != null && (areaName.equals(area.getName()) || aCache) )
			//	continue;
			
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
