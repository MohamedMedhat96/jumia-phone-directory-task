package com.example.phone.directory.service.customer;

import java.util.List;

import com.example.phone.directory.repository.country.CountryRepository;
import com.example.phone.directory.repository.customer.CustomerRepository;
import com.example.phone.directory.service.country.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.phone.directory.exceptions.IncorrectInputException;
import com.example.phone.directory.model.country.Country;
import com.example.phone.directory.model.customer.Customer;
import com.example.phone.directory.model.search.SearchObject;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	CountryService countryService;

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	public Page<Customer> getCustomersPagedAndFiltered(Pageable pageable, SearchObject search) {
		switch(search.searchField)
		{
		case STATE:
			return customerRepo.findByPhoneNumberState(Boolean.valueOf(search.getSearchValue()), pageable);
		case COUNTRY:
		{
			List<Customer> customers = customerRepo.findAll();
			Country country = countryService.getCountryByCountryName(search.getSearchValue());
			if(country != null) {
				return customerRepo.findByCountryId(country.getId(), pageable);
			}else {
				throw new IncorrectInputException("The country you have entered does not exist", HttpStatus.NOT_FOUND);
			}
		}
		default:
			throw new IncorrectInputException(search.getSearchField().name() + " does not exist", HttpStatus.BAD_REQUEST);
			
		}
	}

	public Page<Customer> getCustomerPaged(Pageable pageable) {
		return customerRepo.findAll(pageable);
	}
}
