package com.scb.rdm.service.impl;

import java.util.List;

import com.scb.rdm.aspect.TransactionEnabled;
import com.scb.rdm.entity.Country;
import com.scb.rdm.repository.CountryRepository;
import com.scb.rdm.service.ReferenceDataService;

/**
 * The Reference Data Service Implementation provides the implementation for the
 * Reference Data Service. This wraps the call to the repository beans.
 * 
 * @author prabusivakumar
 *
 */
public class ReferenceDataServiceImpl implements ReferenceDataService {

	private CountryRepository countryRepository;

	public void init() {
		System.out.println("ReferenceDataServiceImpl.init()");
		List<Country> countries = this.getCountryRepository().findAll();
		for (Country country : countries) {
			System.out.println(country);
		}
	}

	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@TransactionEnabled
	public List<Country> fetchAllCountries() {
		return getCountryRepository().findAll();
	}

}
