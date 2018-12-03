package com.mcd.mars.business;

import org.springframework.stereotype.Service;

import com.mcd.mars.data.entity.Area;
import com.mcd.mars.data.entity.Product;
import com.mcd.mars.data.entity.Promotion;
import com.mcd.mars.data.entity.Role;
import com.mcd.mars.data.entity.User;

@Service
public class RestaurantPromotion {
	private Area area;
	private Product product;
	private Promotion promotion;
	private Role role;
	private User user;
	
	public RestaurantPromotion() {
		this(null, null, null, null, null);
	}
	
	public RestaurantPromotion(Area area, Product product, Promotion promotion, Role role, User user) {
		this.area = area;
		this.product = product;
		this.promotion = promotion;
		this.role = role;
		this.user = user;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return promotion + "\n" + area + "\n" + product + "\n" + user + "\n";
	}
}
