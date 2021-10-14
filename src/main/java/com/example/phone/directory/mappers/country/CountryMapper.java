package com.example.phone.directory.mappers.country;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.phone.directory.dto.country.CountryDTO;
import com.example.phone.directory.model.country.Country;


@Mapper(componentModel = "spring")
public abstract class CountryMapper {

	@Mappings({
		@Mapping(target = "countryCode", source="country.code"),
		@Mapping(target= "countryName", source = "country.name"),
	})
	public abstract CountryDTO countryToCountryDTO(Country country);
}
