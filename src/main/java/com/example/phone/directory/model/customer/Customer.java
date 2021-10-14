package com.example.phone.directory.model.customer;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.phone.directory.model.AbstractModel;
import com.example.phone.directory.model.country.Country;
import com.example.phone.directory.model.phone.PhoneNumber;

@Entity
@Table(name = "customer")
public class Customer extends AbstractModel {
	 
	@Embedded
	private PhoneNumber phoneNumber;
	
	@Column(name = "name")
	private String fullName;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
