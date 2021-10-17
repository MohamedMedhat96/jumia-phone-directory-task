package com.example.phone.directory.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.phone.directory.helper.validator.PhoneNumberValidator;
import com.example.phone.directory.mappers.phone.PhoneMapper;
import com.example.phone.directory.service.country.CountryService;
import com.example.phone.directory.service.customer.CustomerService;
import com.example.phone.directory.service.phoneNumber.PhoneNumberService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {PhoneNumberService.class})
public class PhoneNumberServiceTest {

	@Autowired
	PhoneNumberService phoneNumberService;
	
	@MockBean
	CustomerService customerService;
	
	@MockBean
	CountryService countryService;
	
	@MockBean
	PhoneNumberValidator phoneNumberValidator;
	
	@MockBean
	PhoneMapper phoneMapper;
	
	
}
