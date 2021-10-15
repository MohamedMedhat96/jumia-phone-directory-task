package com.example.phone.directory.service.phoneNumber;

import java.util.ArrayList;
import java.util.List;

import com.example.phone.directory.dto.country.CountryDTO;
import com.example.phone.directory.dto.phone.PhoneNumberDTO;
import com.example.phone.directory.service.country.CountryService;
import com.example.phone.directory.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.phone.directory.helper.validator.PhoneNumberValidator;
import com.example.phone.directory.mappers.phone.PhoneMapper;
import com.example.phone.directory.model.country.Country;
import com.example.phone.directory.model.customer.Customer;
import com.example.phone.directory.model.search.SearchObject;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CountryService countryService;

	@Autowired
	PhoneNumberValidator phoneNumberValidator;
	
	@Autowired
	PhoneMapper phoneMapper;
	
	public List<PhoneNumberDTO> getAllPhoneNumbers(Integer page, Integer size)
	{
		List<Customer> customers;
		if(page == null || size == null)
			 customers = customerService.getAllCustomers();
		else {
			Pageable pageable = PageRequest.of(page, size);
			customers = customerService.getCustomerPaged(pageable);
		}
		return getPhoneNumbersFromCustomers(customers);
	}
	
	
	public List<PhoneNumberDTO> getPhoneNumbers(Integer page, Integer size, SearchObject search){
		if((page == null || size == null) && search ==  null)
				return getAllPhoneNumbers(page, size);
		else {
			Pageable pageable ;
			if(page == null || size == null)
				pageable = null;
			else
				pageable = PageRequest.of(page, size);
			if (search != null) {
				List<Customer> customers =  customerService.getCustomersPagedAndFiltered(pageable, search);
				return getPhoneNumbersFromCustomers(customers);
			} else {
				List<Customer> customers = customerService.getCustomerPaged(pageable);
				return getPhoneNumbersFromCustomers(customers);
			}
		}
	}
	
	private List<PhoneNumberDTO> getPhoneNumbersFromCustomers(List<Customer> customers){
		List<PhoneNumberDTO> phoneNumbers = new ArrayList<PhoneNumberDTO>();
		for(Customer customer: customers) 
		{
			Country country = customer.getCountry();
			PhoneNumberDTO phoneNumberDTO = phoneMapper.phoneNumberToPhoneNumberDTO(customer.getPhoneNumber(), country, country != null);
			phoneNumbers.add(phoneNumberDTO);
		}
		return phoneNumbers;
	}
	
}
