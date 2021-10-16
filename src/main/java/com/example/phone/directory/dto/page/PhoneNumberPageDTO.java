package com.example.phone.directory.dto.page;

import java.util.List;

import com.example.phone.directory.dto.phone.PhoneNumberDTO;

public class PhoneNumberPageDTO extends PageDTO {

	private List<PhoneNumberDTO> phoneNumbers;

	public List<PhoneNumberDTO> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public Long getTotalElements() {
		return super.getTotalElements();
	}

	public void setTotalElements(Long totalElements) {
		super.setTotalElements(totalElements);
	}

	public Long getTotalPages() {
		return super.getTotalPages();
	}

	public void setTotalPage(Long totalPages) {
		super.setTotalPages(totalPages);
	}

	
}
