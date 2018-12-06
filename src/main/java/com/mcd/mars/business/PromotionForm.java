package com.mcd.mars.business;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PromotionForm {
	@Positive(message="Please select an area for this promotion.")
	private long area;
	@Positive(message="Please select a product for this promotion.")
	private long product;
	
	@NotNull(message="Please enter a date in MM-dd-YYYY format.")
	private String startDate;
	
	@NotNull(message="Please enter a date in MM-dd-YYYY format.")
	private String endDate;
	
	@NotBlank(message="Promotion name cannot be empty.")
	private String name;
	
	@NotBlank(message="Promotion description cannot be empty.")
	@Size(min = 4, max = 100)
	private String description;
	
	public PromotionForm() {
		this.name = null;
		this.description = null;
		this.startDate = null;
		this.endDate = null;
		this.area = -1;
		this.product = -1;
	}
	
	public PromotionForm(String name, String description, String startDate, String endDate, long areaId, long productId) {
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.area = areaId;
		this.product = productId;
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	public long getProduct() {
		return product;
	}

	public void setProduct(long product) {
		this.product = product;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
