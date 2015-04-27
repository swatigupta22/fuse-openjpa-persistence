package com.scb.rdm.service;

import java.util.List;

import com.scb.rdm.entity.Country;

/**
 * The Reference Data Service will wrap the calls to the Repository beans. The
 * Reference Data Service will be exposed as the OSGi Service for the JAX-RS
 * bundle.
 * 
 * @author prabusivakumar
 *
 */
public interface ReferenceDataService {

	/**
	 * Method to fetch all the Country Entities.
	 * 
	 * @return The List<Country>
	 */
	public List<Country> fetchAllCountries();

	/**
	 * Method to save the Country Entity.
	 * 
	 * @param country
	 *            The {@link Country}
	 */
	public void saveCountry(Country country);

}
