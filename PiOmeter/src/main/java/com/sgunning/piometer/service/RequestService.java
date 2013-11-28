package com.sgunning.piometer.service;

import java.util.Collection;
import org.springframework.dao.DataAccessException;

import com.sgunning.piometer.model.WebRequest;

public interface RequestService {

	public abstract Collection<WebRequest> getWebRequests(String location)
			throws DataAccessException;
	
	public void addWebRequest(WebRequest webRequest)
			throws DataAccessException;


}