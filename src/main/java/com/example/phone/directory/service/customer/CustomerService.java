package com.example.phone.directory.service.customer;

import java.util.List;

import com.example.phone.directory.repository.country.CountryRepository;
import com.example.phone.directory.repository.customer.CustomerRepository;
import com.example.phone.directory.service.country.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.phone.directory.model.customer.Customer;
import com.example.phone.directory.model.search.SearchObject;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	CountryService countryService;

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public List<Customer> getCustomersPagedAndFiltered(Pageable pageable, SearchObject search) {
		if(search.getSearchField().equals(SearchObject.SearchField.STATE))
			return customerRepo.findbyState(Boolean.valueOf(search.getSearchValue()));
	}

	public List<Customer> getCustomerPaged(Pageable pageable) {
		return customerRepo.findAll(pageable).getContent();
	}
}
