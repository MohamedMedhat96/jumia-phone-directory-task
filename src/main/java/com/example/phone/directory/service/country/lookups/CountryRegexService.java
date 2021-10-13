package com.example.phone.directory.service.country.lookups;

import com.example.phone.directory.model.lookups.CountryRegex;
import com.example.phone.directory.repository.CountryRegexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryRegexService {

    @Autowired
    private CountryRegexRepository countryRegexRepository;

    public List<CountryRegex> getAllCountryRegex(){
        return countryRegexRepository.findAll();
    }
}
