package com.mcd.mars.business;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

public class PromotionForm {
	@Positive(message="Please select an area for this promotion.")
	private long area;
	@Positive(message="Please select a product for this promotion.")
	private long product;
	
	@NotNull(message="Please enter promotion start date in MM-dd-YYYY format.")
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date startDate;
	
	@NotNull(message="Please enter promotion end date in MM-dd-YYYY format.")
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date endDate;
	
	@NotBlank(message="Promotion name cannot be empty.")
	private String name;
	
	@NotBlank(message="Promotion description cannot be empty.")
	private String description;
	
	public PromotionForm() {
		this(null, null, null, null, -1, -1);
	}
	
	public PromotionForm(String name, String description, Date startDate, Date endDate, long areaId, long productId) {
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
	
	public String getName() {
		return name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
