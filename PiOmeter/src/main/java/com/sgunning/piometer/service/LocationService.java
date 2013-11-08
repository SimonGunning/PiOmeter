package com.sgunning.piometer.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgunning.piometer.model.Location;
@Service
public class LocationService {
	@Autowired
	 public Set <Location> getLocations(){
		Set <Location> locationSet = new HashSet<Location>();
		Location loc1 = new Location("London");
		locationSet.add(loc1);
		Location loc2 = new Location("New York");
		locationSet.add(loc2);
		Location loc3 = new Location("Hong Kong");
		locationSet.add(loc3);
		Location loc4 = new Location("Tokyo");
		locationSet.add(loc4);
		
		
		return locationSet ;
	}
}
