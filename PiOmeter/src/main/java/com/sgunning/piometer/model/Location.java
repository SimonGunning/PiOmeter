package com.sgunning.piometer.model;

public class Location {
	public Location() {

	}

	public Location(String name) {
		super();
		this.name = name;
	}

	public Location(String name, long averageDuration) {
		super();
		this.name = name;
		this.averageDuration = averageDuration;
	}

	private String name;
	private long averageDuration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAverageDuration() {
		return averageDuration;
	}

	public void setAverageDuration(long averageDuration) {
		this.averageDuration = averageDuration;
	}

}
