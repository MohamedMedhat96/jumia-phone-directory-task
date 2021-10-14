package com.example.phone.directory.helper.validator;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberValidator {

	private Pattern pattern;
	
	private Matcher matcher;
	
	public boolean validate(String countryRegex, String phoneNumber) {
		pattern = Pattern.compile(countryRegex);
		matcher = pattern.matcher(phoneNumber);
		if(matcher.find())
			return true;
		else
			return false;
	}
	
	
}
