package com.example.phone.directory.service.phoneNumber;

import java.util.ArrayList;
import java.util.List;

import com.example.phone.directory.dto.country.CountryDTO;
import com.example.phone.directory.dto.phone.PhoneNumberDTO;
import com.example.phone.directory.service.country.CountryService;
import com.example.phone.directory.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.phone.directory.helper.validator.PhoneNumberValidator;
import com.example.phone.directory.model.customer.Customer;

@Service
public class PhoneNumberService {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CountryService countryService;

	@Autowired
	PhoneNumberValidator phoneNumberValidator;
	
	public List<PhoneNumberDTO> getAllPhoneNumbers()
	{
		List<Customer> customers = customerService.getAllCustomers();
		List<PhoneNumberDTO> phoneNumbers = new ArrayList<PhoneNumberDTO>();
		for(Customer customer: customers)
		{
			String countryName = countryService.getCountryName(customer.getPhoneNumber().getNumber());
			String countryCode = countryService.getCountryCode(countryName);

			PhoneNumberDTO phoneNumberDTO = new PhoneNumberDTO();
			CountryDTO countryDTO = new CountryDTO();

			countryDTO.setCountryCode(countryCode);
			countryDTO.setCountryName(countryName);
			phoneNumberDTO.setPhoneNumber(customer.getPhoneNumber().getNumber());
			phoneNumberDTO.setCountry(countryDTO);
			phoneNumberDTO.setState(countryName != null);
			phoneNumbers.add(phoneNumberDTO);
		}
		return phoneNumbers;
	}
	
	
}
