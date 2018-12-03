package com.mcd.mars.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Promotion {
	@Id @Column @GeneratedValue private long id;
	@Column private String name;	
	@Column private String description;
	@Column private long areaId;
	@Column private long productId;
	@Column private Date startDate;
	@Column private Date endDate;
	@Column private Date modifiedDate;
	@Column private long modifiedUserId;

	/*
	 * Entity class needs default constructor.
	 * Else, org.hibernate.InstantiationException is thrown.
	 */
	public Promotion() {
		this(null, null, -1, -1, null, null, null, -1);
	}
	
	public Promotion(String name, String description, long areaId,
		long productId, Date startDate, Date endDate,
		Date modifiedDate, long modifiedUserId)
	{
		this.name = name;
		this.description = description;
		this.areaId = areaId;
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modifiedDate = modifiedDate;
		this.modifiedUserId = modifiedUserId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getAreaId() {
		return areaId;
	}

	public void setAreaId(long areaId) {
		this.areaId = areaId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public long getModifiedUserId() {
		return modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}
	
	@Override
	public String toString() {
		return "Promotion - [id: " + id + ", name: " + name + ", description: " + description + ", areaId: " + areaId + ", productId: " + productId + ", startDate: " + startDate + ", endDate: " + endDate + "]";
	}
}
