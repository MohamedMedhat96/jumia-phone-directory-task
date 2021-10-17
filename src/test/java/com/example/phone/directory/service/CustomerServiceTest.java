package com.example.phone.directory.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.phone.directory.repository.customer.CustomerRepository;
import com.example.phone.directory.service.country.CountryService;
import com.example.phone.directory.service.customer.CustomerService;
import com.example.phone.directory.service.customer.CustomerServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CustomerServiceImpl.class})
public class CustomerServiceTest {
	
	@Autowired
	CustomerService customerService;
	
	@MockBean
	CustomerRepository customerRepo;
	
	@MockBean
	CountryService countryService;

}
