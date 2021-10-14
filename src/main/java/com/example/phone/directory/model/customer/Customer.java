package com.example.phone.directory.model.customer;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.phone.directory.model.AbstractModel;
import com.example.phone.directory.model.phone.PhoneNumber;

@Entity
@Table(name = "customer")
public class Customer extends AbstractModel {
	 
	@Embedded
	private PhoneNumber phoneNumber;
	
	@Column(name = "name")
	private String fullName;


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
