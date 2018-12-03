package com.mcd.mars.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id @Column @GeneratedValue private long id;
	@Column private String name;
	@Column private String category;
	
	public Product() {
		this(null, null);
	}
	
	public Product(String name, String category) {
		this.name = name;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product - [id: " + id + ", name: " + name + ", category: " + category + "]";
	}
}
