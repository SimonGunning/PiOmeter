package com.sgunning.piometer.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.sgunning.piometer.model.WebRequest;


/**
 * Repository class for <code>WebRequest</code> domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 *
 */
public interface WebRequestRepository {

    /**
     * Retrieve <code>WebRequest</code>s from the data store 
     *
     * @param lastName Value to search for
     * @return a <code>Collection</code> of matching <code>Owner</code>s (or an empty <code>Collection</code> if none
     *         found)
     */
    Collection<WebRequest> findAllWebRequestByLocation(String locationName) throws DataAccessException;



    /**
     * Save an <code>WebRequest</code> to the data store, either inserting or updating it.
     *
     * @param WebRequest the <code>WebRequest</code> to save
     * @see BaseEntity#isNew
     */
    void save(WebRequest webRequest) throws DataAccessException;


}
