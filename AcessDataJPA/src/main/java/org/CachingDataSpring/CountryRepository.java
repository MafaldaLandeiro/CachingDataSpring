package org.CachingDataSpring;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
	@Cacheable("countries")
	List<Country> findByCurrency(String currency);

}
