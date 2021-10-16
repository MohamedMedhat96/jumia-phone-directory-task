package com.example.phone.directory.mappers.phone;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.phone.directory.dto.page.PhoneNumberPageDTO;
import com.example.phone.directory.dto.phone.PhoneNumberDTO;
import com.example.phone.directory.mappers.country.CountryMapper;
import com.example.phone.directory.model.country.Country;
import com.example.phone.directory.model.phone.PhoneNumber;

@Mapper(componentModel = "spring")
public abstract class PhoneMapper {

	@Autowired
	CountryMapper countryMapper;
	
	@Mappings({
		@Mapping(target = "phoneNumber", source="phone.number"),
		@Mapping(target="state", source = "phone.state"),
		@Mapping(target="country", expression = "java(countryMapper.countryToCountryDTO(country))")
	})
	public abstract PhoneNumberDTO phoneNumberToPhoneNumberDTO(PhoneNumber phone
			, Country country);
	
	@Mappings({
		@Mapping(target="totalElements", source = "totalElements"),
		@Mapping(target="totalPages", source = "totalPages"),
		@Mapping(target = "phoneNumbers", source="phones"),
	})
	public abstract PhoneNumberPageDTO phoneNumberDtosToPhoneNumberPageDTO(
			Long totalElements, Long totalPages, List<PhoneNumberDTO> phones);
}
