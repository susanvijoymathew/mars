package com.mcd.mars.business;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FilterForm {
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date startDate;
	
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date endDate;
	
	private long area;
	
	public FilterForm() {
		this(null, null, -1);
	}
	
	public FilterForm(Date startDate, Date endDate, long place) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.area = place;
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

	public long getArea() {
		return area;
	}

	public void setArea(long place) {
		this.area = place;
	}
}
