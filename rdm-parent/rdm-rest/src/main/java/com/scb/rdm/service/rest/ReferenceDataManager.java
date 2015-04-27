package com.scb.rdm.service.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.scb.rdm.entity.Country;
import com.scb.rdm.service.ReferenceDataService;

/**
 * JAX-RS REST API for the Reference Data Management Service.
 * 
 * @author prabusivakumar
 *
 */
@Path("/refdata")
@Produces(MediaType.APPLICATION_JSON)
public class ReferenceDataManager {

	private ReferenceDataService referenceDataService;

	public ReferenceDataService getReferenceDataService() {
		return referenceDataService;
	}

	/**
	 * Inject the ReferenceDataService through Blueprint Dependency Injection.
	 * 
	 * @param referenceDataService
	 *            The {@link ReferenceDataService}
	 */
	public void setReferenceDataService(
			ReferenceDataService referenceDataService) {
		this.referenceDataService = referenceDataService;
	}

	/**
	 * GET API to fetch the list of Countries.
	 * 
	 * @return
	 */
	@GET
	@Path("/country")
	public List<Country> getAllCountries() {
		return getReferenceDataService().fetchAllCountries();
	}

	/**
	 * PUT API to add a new country to the Reference Data Mart.
	 * 
	 * @return
	 */
	@PUT
	@Path("/country/add/{countryCode}/{description}/{region}")
	public Response addCountry(@PathParam("countryCode") String countryCode,
			@PathParam("description") String description,
			@PathParam("region") String region) {
		getReferenceDataService().saveCountry(
				new Country(countryCode, description, region));
		return Response.ok().build();
	}
}
