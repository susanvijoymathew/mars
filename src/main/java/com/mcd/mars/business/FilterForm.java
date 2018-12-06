package com.mcd.mars.business;

import javax.validation.constraints.NotNull;

public class FilterForm {
	@NotNull(message="Please enter a date in MM/dd/YYYY format.")
	private String startDate;
	@NotNull(message="Please enter a date in MM/dd/YYYY format.")
	private String endDate;
	long location;
	
	public FilterForm() {
		this(null, null, -1);
	}
	
	public FilterForm(String startDate, String endDate, long place) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = place;
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

	public long getLocation() {
		return location;
	}

	public void setLocation(long place) {
		this.location = place;
	}
}
