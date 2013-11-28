package com.sgunning.piometer.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;

import com.sgunning.piometer.model.Location;
import com.sgunning.piometer.model.WebRequest;
import com.sgunning.piometer.service.RequestService;

@Controller
@RequestMapping(value = "/webrequest")
public class WebRequestController {

	private static final Logger logger = LoggerFactory
			.getLogger(WebRequestController.class);
	private RequestService requestService;

	@Autowired
	public WebRequestController(RequestService requestService) {
		this.requestService = requestService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<WebRequest> getWebRequest() throws ParseException {
		logger.info("in getWebRequest");
/*		Location location = new Location("London");
		String s = "03/24/2013 21:54";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm");
		Date date = simpleDateFormat.parse(s);

		WebRequest myWebRequest = new WebRequest(date, date, location,
				"some stuff");
*/
		Collection<WebRequest> myWebRequests = requestService.getWebRequests("London");
		return myWebRequests;
	}

	// @RequestStatus(HttpStatus.CREATED)

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public WebRequest createWebRequest(@RequestBody WebRequest webRequest) {
		logger.info("in createWebRequest");
		requestService.addWebRequest(webRequest);

		return webRequest;

	}

}
