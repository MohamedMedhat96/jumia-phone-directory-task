package com.example.phone.directory.service.customer;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.phone.directory.model.customer.Customer;
import com.example.phone.directory.model.search.SearchObject;

public interface CustomerService {

	public Page<Customer> getCustomersPagedAndFiltered(Pageable pageable, SearchObject search);
	
	public Page<Customer> getCustomerPaged(Pageable pageable);
	
	public List<Customer> getAllCustomers();
}
