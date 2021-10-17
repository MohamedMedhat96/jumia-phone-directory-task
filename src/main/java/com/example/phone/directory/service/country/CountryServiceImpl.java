package com.example.phone.directory.service.country;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.phone.directory.repository.country.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.phone.directory.helper.validator.PhoneNumberValidator;
import com.example.phone.directory.model.country.Country;

@Service
public class CountryServiceImpl implements CountryService{
	

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	PhoneNumberValidator numberValidator;
	
	public Country getCountryByPhoneNumber(String phoneNumber){
		List<Country> countryList = countryRepository.findAll();
		Optional<Country> country = countryList.stream().filter(e-> numberValidator.validate(e.getRegex(), phoneNumber))
		  .findFirst();	
		if(!country.isPresent())
			return null;
		else
			return country.get();
	}
	
	public Country getCountryByCountryName(String country) {
		return countryRepository.findFirstByNameIgnoreCase(country);
	}


}
