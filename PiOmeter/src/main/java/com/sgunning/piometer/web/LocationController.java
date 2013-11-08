package com.sgunning.piometer.web;

import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sgunning.piometer.model.WebRequest;
import com.sgunning.piometer.service.RequestService;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	private RequestService requestService;
	
	private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

	@Autowired
	public LocationController(RequestService requestService) {
		this.requestService = requestService;
	}


	@RequestMapping(value="/location", method=RequestMethod.GET)
	public String listRequestsForLocation(@RequestParam("location") String location, Model model) throws ParseException{
		logger.info("in listRequestsForLocation");
		Collection<WebRequest> results = this.requestService.getWebRequests(location);
		
		 if (results.size() < 1) {
	            // no owners found
	            return "location/requestList";
	        }
	        if (results.size() >= 1) {
	            // multiple owners found
	            model.addAttribute("requests", results);
	            return "location/requestList";
	        } 

/*		if (requestService.getWebRequests().isEmpty()){
			System.out.println("there are no WRs");
		}
		else {
			Iterator<WebRequest> iterator = requestService.getWebRequests().iterator();			 
			while (iterator.hasNext()) {
				WebRequest myWebRequest = iterator.next();
				System.out.println("here is url of W1..  ");
				System.out.println(myWebRequest.getRequestUrl());
			}
		}
*/
			
//		WebRequest wr = requestService.getWebRequests().
//		logger.info("Welcome to Location Controller, listrequests!" + requestService.getWebRequests());

//		model.addAttribute("requests", requestService.getWebRequests());
	
		return "location/requestList";
		
	}

}
