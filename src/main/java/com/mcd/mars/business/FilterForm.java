package com.mcd.mars.business;

import java.util.Date;

public class FilterForm {
	Date startDate;
	Date endDate;
	long location;
	
	public FilterForm() {
		this(null, null, -1);
	}
	
	public FilterForm(Date startDate, Date endDate, long place) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = place;
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

	public long getLocation() {
		return location;
	}

	public void setLocation(long place) {
		this.location = place;
	}
}
