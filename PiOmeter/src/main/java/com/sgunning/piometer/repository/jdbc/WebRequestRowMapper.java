package com.sgunning.piometer.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.sgunning.piometer.model.WebRequest;

public class WebRequestRowMapper implements RowMapper<WebRequest>{

	public WebRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		
//		List<WebRequest> webRequests = new ArrayList<WebRequest>();
		WebRequest webRequest = new WebRequest();
		
		webRequest.setRequestUrl(rs.getString("requesturl"));
		webRequest.setStartTime(rs.getDate("startdate"));
		webRequest.setEndTime(rs.getDate("enddate"));
//		webRequest.setLocation(location)
		return webRequest;
	}

}
