package com.example.phone.directory.service.phoneNumber;

import java.util.List;

import com.example.phone.directory.dto.page.PhoneNumberPageDTO;
import com.example.phone.directory.dto.phone.PhoneNumberDTO;
import com.example.phone.directory.model.search.SearchObject;

public interface PhoneNumberService {

	public PhoneNumberPageDTO getAllPhoneNumbers(Integer page, Integer size);
	
	public PhoneNumberPageDTO getPhoneNumbers(Integer page, Integer size, SearchObject search);
}
