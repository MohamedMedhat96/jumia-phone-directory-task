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
import com.example.phone.directory.mappers.phone.PhoneMapper;
import com.example.phone.directory.model.country.Country;
import com.example.phone.directory.model.customer.Customer;

@Service
public class PhoneNumberService {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CountryService countryService;

	@Autowired
	PhoneNumberValidator phoneNumberValidator;
	
	@Autowired
	PhoneMapper phoneMapper;
	
	public List<PhoneNumberDTO> getAllPhoneNumbers()
	{
		List<Customer> customers = customerService.getAllCustomers();
		List<PhoneNumberDTO> phoneNumbers = new ArrayList<PhoneNumberDTO>();
		for(Customer customer: customers)
		{
			Country country = countryService.getCountryByPhoneNumber(customer.getPhoneNumber().getNumber());
			PhoneNumberDTO phoneNumberDTO = phoneMapper.phoneNumberToPhoneNumberDTO(customer.getPhoneNumber(), country, country != null);
			phoneNumbers.add(phoneNumberDTO);
		}
		return phoneNumbers;
	}
	
	
}
