package com.example.phone.directory.service.customer;


import java.util.List;

import com.example.phone.directory.model.lookups.CountryCodes;
import com.example.phone.directory.model.sorting.SortingDirection;
import com.example.phone.directory.repository.CountryCodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.phone.directory.model.customer.Customer;
import com.example.phone.directory.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	CountryCodesRepository countryCodesRepository;

	public List<Customer> getAllCustomers(){

	List<CountryCodes> countryCodes = 	countryCodesRepository.findAll();
		return customerRepo.findAll();
	}

	public List<Customer> getCustomers(Integer pageNumber, Integer size, String sortField, SortingDirection direction){
		Pageable pageable;
		if(pageNumber == null || size == null)
				return getAllCustomers();
		else {
			if (sortField == null) {
				pageable = PageRequest.of(pageNumber, size);
				return customerRepo.findAll(pageable).getContent();
			} else {
				if(direction.equals(SortingDirection.ASC))
					pageable = PageRequest.of(pageNumber, size, Sort.by(sortField).ascending());
				else
					pageable = PageRequest.of(pageNumber, size, Sort.by(sortField).descending());
				return null;
			}
		}
	}
}
