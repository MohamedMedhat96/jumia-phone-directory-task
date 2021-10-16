package com.example.phone.directory.dto.phone;

import com.example.phone.directory.dto.country.CountryDTO;

public class PhoneNumberDTO {

	private Long id;
	
    private CountryDTO country;

    private String phoneNumber;

    private Boolean state;

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
