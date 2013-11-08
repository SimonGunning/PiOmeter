package com.sgunning.piometer.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sgunning.piometer.model.WebRequest;
import com.sgunning.piometer.repository.WebRequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	/* (non-Javadoc)
	 * @see com.sgunning.piometer.service.RequestService#getWebRequests()
	 */
	
	private WebRequestRepository webRequestRepository;
	
	@Autowired
	public RequestServiceImpl(WebRequestRepository webRequestRepository) {
		super();
		this.webRequestRepository = webRequestRepository;
	}

	public Collection <WebRequest> getWebRequests(String location) throws DataAccessException {
		

		return webRequestRepository.findAllWebRequestByLocation(location);

	}

}
