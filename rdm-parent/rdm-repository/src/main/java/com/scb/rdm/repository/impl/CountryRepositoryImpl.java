package com.scb.rdm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import com.scb.rdm.entity.Country;
import com.scb.rdm.repository.CountryRepository;

/**
 * The Country Repository Implementation provides the implementation for the
 * {@link CountryRepository}.
 * 
 * @author prabusivakumar
 *
 */
public class CountryRepositoryImpl implements CountryRepository {

	private EntityManager entityManager;

	public void init() {
		System.out.println("Country Repository Initialized");
		List<Country> countries = this.findAll();
		System.out.println("Number of Countries retrieved is "
				+ countries.size());
		for (Country country : countries) {
			System.out.println(country);
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Inject the container managed Entity Manager through Blueprint Dependency
	 * Injection.
	 * 
	 * @param entityManager
	 *            The EntityManager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Country> findAll() {
		System.out.println("Calling the FindAll API on the Country Repository");
		CriteriaQuery<Country> cq = getEntityManager().getCriteriaBuilder()
				.createQuery(Country.class);
		cq.select(cq.from(Country.class));
		return getEntityManager().createQuery(cq).getResultList();
	}

	public void persist(Country entity) {
		getEntityManager().persist(entity);
	}

}
