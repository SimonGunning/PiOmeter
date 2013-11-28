package com.sgunning.piometer.model;

import java.util.Date;



public class WebRequest {
	
	public WebRequest(Date startTime, Date endTime, Location location,
			String requestUrl) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.requestUrl = requestUrl;
	}
	
	public WebRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Date startTime;
	private Date endTime;
	private Location location;
	private String requestUrl;
	private boolean success;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
