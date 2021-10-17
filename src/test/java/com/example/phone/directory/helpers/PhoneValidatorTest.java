package com.example.phone.directory.helpers;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.phone.directory.helper.validator.PhoneNumberValidator;
import com.example.phone.directory.service.phoneNumber.PhoneNumberServiceImpl;

import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {PhoneNumberValidator.class})
public class PhoneValidatorTest {

	@Autowired 
	PhoneNumberValidator phoneValidator;
	
	@Test
	public void validatePhoneNumberFail() {
		String regex = "\\(237\\)\\ ?[2368]\\d{7,8}$";
		String phoneNumber = "(212) 6007989253";
		
		boolean isValid = phoneValidator.validate(regex, phoneNumber);
		
		assertThat(isValid, is(false));
	}
	
	@Test
	public void validatePhoneNumberSuceed() {
		String regex = "\\(212\\)\\ ?[5-9]\\d{8}$";
		String phoneNumber = "(212) 698054317";
		
		boolean isValid = phoneValidator.validate(regex, phoneNumber);
		
		assertThat(isValid, is(true));
	}
}
