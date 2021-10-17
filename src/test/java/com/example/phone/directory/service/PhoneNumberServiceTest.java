package com.example.phone.directory.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.phone.directory.dto.page.PhoneNumberPageDTO;
import com.example.phone.directory.helper.validator.PhoneNumberValidator;
import com.example.phone.directory.mappers.phone.PhoneMapper;
import com.example.phone.directory.model.customer.Customer;
import com.example.phone.directory.model.search.SearchObject;
import com.example.phone.directory.model.search.SearchObject.SearchField;
import com.example.phone.directory.repository.customer.CustomerRepository;
import com.example.phone.directory.service.country.CountryService;
import com.example.phone.directory.service.customer.CustomerService;
import com.example.phone.directory.service.phoneNumber.PhoneNumberService;
import com.example.phone.directory.service.phoneNumber.PhoneNumberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {PhoneNumberServiceImpl.class})
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
	
	@Test
	public void getAllPhoneNumbersNonPagedTest() {
		
		Pageable page = Pageable.unpaged();
		when(customerService.getCustomerPaged(page)).thenReturn(new PageImpl<Customer>(new ArrayList<Customer>()));
		phoneNumberService.getAllPhoneNumbers(null, null);
		verify(customerService,times(1)).getCustomerPaged(page);
	}
	
	@Test
	public void getAllPhoneNumbersPagedTest() {
		
		Pageable page = PageRequest.of(1, 10);
		when(customerService.getCustomerPaged(page)).thenReturn(new PageImpl<Customer>(new ArrayList<Customer>()));
		phoneNumberService.getAllPhoneNumbers(1, 10);
		verify(customerService,times(1)).getCustomerPaged(page);
	}
	
	@Test
	public void getPhoneNumbersPagedWithNoSearchTest() {
		
		Pageable page = PageRequest.of(1, 10);
		when(customerService.getCustomerPaged(page)).thenReturn(new PageImpl<Customer>(new ArrayList<Customer>()));
		phoneNumberService.getPhoneNumbers(1, 10, null);
		verify(customerService,times(1)).getCustomerPaged(page);
	}
	
	@Test
	public void getPhoneNumbersNotPagedWithNoSearchTest() {
		Pageable page = Pageable.unpaged();
		when(customerService.getCustomerPaged(page)).thenReturn(new PageImpl<Customer>(new ArrayList<Customer>()));
		phoneNumberService.getPhoneNumbers(null, null, null);
		verify(customerService,times(1)).getCustomerPaged(page);
	}
	
	@Test
	public void getPhoneNumbersPagedWithSearchTest() {
		
		Pageable page = PageRequest.of(1, 10);
		SearchObject search = new SearchObject();
		search.setSearchField(SearchField.COUNTRY);
		search.setSearchValue("Egypt");
		when(customerService.getCustomersPagedAndFiltered(page, search)).thenReturn(new PageImpl<Customer>(new ArrayList<Customer>()));
		phoneNumberService.getPhoneNumbers(1, 10, search);
		verify(customerService,times(1)).getCustomersPagedAndFiltered(page, search);
	}
	
	@Test
	public void getPhoneNumbersUnpagedWithSearchTest() {
		
		Pageable page = Pageable.unpaged();
		SearchObject search = new SearchObject();
		search.setSearchField(SearchField.COUNTRY);
		search.setSearchValue("Egypt");
		when(customerService.getCustomersPagedAndFiltered(page, search)).thenReturn(new PageImpl<Customer>(new ArrayList<Customer>()));
		phoneNumberService.getPhoneNumbers(null, null, search);
		verify(customerService,times(1)).getCustomersPagedAndFiltered(page, search);
	}
	
}
