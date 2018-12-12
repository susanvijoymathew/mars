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

	private final String ROOT = "Root";
	private final String CITY = "City"; // should be an enumeration
	private Map<Area, ArrayList<Area>> areaMap;
	
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
		
		createAreaMap(this.getAllAreas());
	}
	
	// When cache is updated or invalidated, ensure map in AreaUtil is updated
	@Cacheable("areas")
	public List<Area> getAllAreas() {
		return areaRepository.findAll();
		/*
		    System.out.println("Printing the areas retrieved from Database");
			String space = "    ";
			for (com.mcd.mars.data.entity.Area a: susanAreas) {
				String spaces = (new String(new char[a.getLevel()]).replace("\0", space));
				System.out.println(spaces + a);
			}
		 */
	}
	
	public List<Area> getAllAreasFor(Area location) {
		List<Area> results = new ArrayList<Area>();
		List<Area> allAreas = this.getAllAreas();

		return results;
	}
	
	private void createAreaMap(List<Area> locations) {
		this.areaMap = new HashMap<Area, ArrayList<Area>>();
		
		for (Area a : locations) {
			// City doesn't have children. If it every does, the following line should be updated.
			if (!areaMap.containsKey(a) && !a.getType().equals(CITY))
				areaMap.put(a, new ArrayList<Area>());
			
			if (!a.getType().equals(ROOT)) {
				Area parent = a.getParent();
				
				ArrayList<Area> children = areaMap.containsKey(parent) ? areaMap.get(parent) : new ArrayList<Area>();
				children.add(a);
				areaMap.put(parent, children);
			}
		}
		
		for (Area a : areaMap.keySet()) {
			System.out.println(a);
			ArrayList<Area> children = areaMap.get(a);
			for (Area c : children) {
				System.out.println("\t" + c);
			}
			System.out.println("\t\t***********************************************************");
		}
	}
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public List<RestaurantPromotion> getAllActivePromotions() {
		List<RestaurantPromotion> usPromos = new ArrayList<RestaurantPromotion> ();
		List<Promotion> promotions = promotionRepository.findAllActivePromotions();
		
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
