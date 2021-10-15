package com.example.phone.directory.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.phone.directory.model.customer.Customer;
import com.example.phone.directory.service.customer.CustomerServiceImpl;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
}
