package com.example.phone.directory.repository.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.phone.directory.model.country.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	public Country findByNameIgnoreCase(String name);
}
