package com.example.phone.directory.service.customer;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.phone.directory.model.customer.Customer;
import com.example.phone.directory.model.search.SearchObject;

public interface CustomerService {

	public List<Customer> getCustomersPagedAndFiltered(Pageable pageable, SearchObject search);
	
	public List<Customer> getCustomerPaged(Pageable pageable);
	
	public List<Customer> getAllCustomers();
}
