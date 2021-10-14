package com.example.phone.directory.model.country;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.phone.directory.model.AbstractModel;

@Entity(name = "country")
public class Country extends AbstractModel{

	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "code", unique = true)
	private String code;

	@Column(name = "regex", unique = true)
	private String regex;
	
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
