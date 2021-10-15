package com.example.phone.directory.service.phoneNumber;

import java.util.List;

import com.example.phone.directory.dto.phone.PhoneNumberDTO;
import com.example.phone.directory.model.search.SearchObject;

public interface PhoneNumberService {

	public List<PhoneNumberDTO> getAllPhoneNumbers(Integer page, Integer size);
	
	public List<PhoneNumberDTO> getPhoneNumbers(Integer page, Integer size, SearchObject search);
}
