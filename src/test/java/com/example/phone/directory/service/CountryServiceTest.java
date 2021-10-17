package com.example.phone.directory.service;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.phone.directory.helper.validator.PhoneNumberValidator;
import com.example.phone.directory.model.country.Country;
import com.example.phone.directory.repository.country.CountryRepository;
import com.example.phone.directory.service.country.CountryService;
import com.example.phone.directory.service.country.CountryServiceImpl;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CountryServiceImpl.class})
public class CountryServiceTest {

	@Autowired
	CountryService countryService;
	
	@MockBean
	CountryRepository countryRepository;
	
	@MockBean
	PhoneNumberValidator numberValidator;
	
	@Test
	public void getCountryByPhoneNumberSucceedTest() {
		String phoneNumber = "(212) 698054317";
		List<Country> countryList = new ArrayList<Country>();
		Country countryCorrect = new Country();
		countryCorrect.setName("Morocco");
		countryCorrect.setCode("+212");
		countryCorrect.setRegex("\\(212\\)\\ ?[5-9]\\d{8}$");
		countryCorrect.setId(1L);
		
		Country countryFalse = new Country();
		countryFalse.setName("Egypt");
		countryFalse.setId(2L);
		countryFalse.setRegex("\\(233\\)\\ ?[5-9]\\d{8}$");
		countryFalse.setCode("+233");
		countryList.add(countryCorrect);
		countryList.add(countryFalse);
		when(countryRepository.findAll()).thenReturn(countryList);
		when(numberValidator.validate(countryCorrect.getRegex(), phoneNumber))
		.thenReturn(true);
		
		Country country  = countryService.getCountryByPhoneNumber(phoneNumber);
		assertThat(country.getId(), is(countryCorrect.getId()));
		}
	
	@Test
	public void getCountryByPhoneNumberFailTest() {
		String phoneNumber = "(212) 698054317";
		List<Country> countryList = new ArrayList<Country>();
		Country countryOne = new Country();
		countryOne.setName("Morocco");
		countryOne.setCode("+212");
		countryOne.setRegex("\\(215\\)\\ ?[5-9]\\d{8}$");
		countryOne.setId(1L);
		
		Country countryTwo = new Country();
		countryTwo.setName("Egypt");
		countryTwo.setId(2L);
		countryTwo.setRegex("\\(233\\)\\ ?[5-9]\\d{8}$");
		countryTwo.setCode("+233");
		countryList.add(countryOne);
		countryList.add(countryTwo);
		when(countryRepository.findAll()).thenReturn(countryList);
		when(numberValidator.validate(countryOne.getRegex(), phoneNumber))
		.thenReturn(false);
		when(numberValidator.validate(countryTwo.getRegex(), phoneNumber))
		.thenReturn(false);
		
		Country country  = countryService.getCountryByPhoneNumber(phoneNumber);
		assertThat(country, nullValue());
		}
	
	@Test
	public void getCountryByCountryNameTest() {
		String countryName = "Morocco";
		List<Country> countryList = new ArrayList<Country>();
		Country countryOne = new Country();
		countryOne.setName("Morocco");
		countryOne.setCode("+212");
		countryOne.setRegex("\\(215\\)\\ ?[5-9]\\d{8}$");
		countryOne.setId(1L);
		countryList.add(countryOne);
		
		when(countryRepository.findFirstByNameIgnoreCase(countryName)).thenReturn(countryOne);
		
		Country country  = countryService.getCountryByCountryName(countryName);
		assertThat(country, is(countryOne));
		}
}
