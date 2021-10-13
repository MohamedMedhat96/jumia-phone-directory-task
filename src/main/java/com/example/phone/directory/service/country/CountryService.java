package com.example.phone.directory.service.country;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.phone.directory.model.lookups.CountryCodes;
import com.example.phone.directory.model.lookups.CountryRegex;
import com.example.phone.directory.repository.CountryCodesRepository;
import com.example.phone.directory.repository.CountryRegexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.phone.directory.helper.validator.PhoneNumberValidator;

@Service
public class CountryService {
	

	@Autowired
	private CountryCodesRepository countryCodesRepository;

	@Autowired
	private CountryRegexRepository countryRegexRepository;

	@Autowired
	PhoneNumberValidator numberValidator;
	
	public String getCountryName(String phoneNumber){
		List<CountryRegex> countryRegexesList = countryRegexRepository.findAll();
		Optional<String> countryName = countryRegexesList.stream().filter(e-> numberValidator.validate(e.getRegex(), phoneNumber))
		  .map(CountryRegex::getName)
		  .findFirst();	
		if(countryName.isEmpty())
			return null;
		else
			return countryName.get();
	}

	public String getCountryCode(String countryName) {
		List<CountryCodes> countryCodes = countryCodesRepository.findAll();
		Optional<String> countryCode =  countryCodes.stream().filter(e -> e.getCountryName().equals(countryName))
				.map(CountryCodes::getCode).findFirst();

		if(countryCode.isEmpty())
			return null;
		else
			return countryCode.get();
	}


}
