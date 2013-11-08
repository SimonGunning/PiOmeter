package com.sgunning.piometer.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.sgunning.piometer.model.WebRequest;
import com.sgunning.piometer.repository.WebRequestRepository;

@Repository
public class JdbcWebRequestRepositoryImpl implements WebRequestRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private DataSource dataSource;

	private SimpleJdbcInsert insertWebRequest;

	@Autowired
	public JdbcWebRequestRepositoryImpl(DataSource dataSource,
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.insertWebRequest = new SimpleJdbcInsert(dataSource).withTableName(
				"webrequests").usingGeneratedKeyColumns("id");
	}

	public Collection<WebRequest> findAllWebRequestByLocation(
			String locationName) throws DataAccessException {
		System.out.println("in jdbc impl...about to call db");
		int myLocationId;
		if (locationName.equalsIgnoreCase("London")) {
			myLocationId = 1;
		} else {
			myLocationId = 2;
		}
		
        switch (locationName.toLowerCase()) {
            case "london":  myLocationId = 1;
                     break;
            case "Hong Kong":  myLocationId = 2;
                     break;
            case "Tokyo":  myLocationId = 3;
                     break;
            
            
            default: myLocationId = 1;
                     break;
        }
		
		
		
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("locationId", myLocationId + "%");
		params.put("locationId", myLocationId);

		List<WebRequest> webrequests = this.namedParameterJdbcTemplate.query(
				"SELECT * FROM  web_requests WHERE location_id = :locationId",
				params, new WebRequestRowMapper());
		return webrequests;
	}

	public void save(WebRequest webRequest) throws DataAccessException {
		// TODO Auto-generated method stub

	}

}
