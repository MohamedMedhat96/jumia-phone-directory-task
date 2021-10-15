package com.example.phone.directory.service.country;

import com.example.phone.directory.model.country.Country;

public interface CountryService {

	public Country getCountryByPhoneNumber(String phoneNumber);
	
	public Country getCountryByCountryName(String country);
}
