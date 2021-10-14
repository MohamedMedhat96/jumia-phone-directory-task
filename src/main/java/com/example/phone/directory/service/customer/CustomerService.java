package com.example.phone.directory.service.customer;


import java.util.List;

import com.example.phone.directory.repository.country.CountryRepository;
import com.example.phone.directory.repository.customer.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.phone.directory.model.customer.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	public List<Customer> getAllCustomers(){

		return customerRepo.findAll();
	}

	public List<Customer> getCustomers(Integer pageNumber, Integer size, String sortField){
		Pageable pageable;
		if(pageNumber == null || size == null)
				return getAllCustomers();
		else {
			if (sortField == null) {
				pageable = PageRequest.of(pageNumber, size);
				return customerRepo.findAll(pageable).getContent();
			} else {
			
				return null;
			}
		}
	}
}
