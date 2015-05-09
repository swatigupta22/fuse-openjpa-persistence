package com.scb.rdm.repository;

import java.util.List;

import com.scb.rdm.entity.Country;
import com.scb.rdm.repository.impl.CountryRepositoryImpl;

/**
 * The Data Access Layer for the Country Entity. The actual implementation is
 * provided by {@link CountryRepositoryImpl}
 * 
 * @author prabusivakumar
 *
 */
public interface CountryRepository {

	/**
	 * The Method to fetch all the countries available in the reference data
	 * management store.
	 * 
	 * @return
	 */
	public abstract List<Country> findAll();

	/**
	 * The Method to save the Country Entity.
	 * 
	 * @param entity
	 */
	public abstract void persist(Country entity);
}
