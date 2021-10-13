package com.example.phone.directory.service.country.lookups;

import com.example.phone.directory.model.lookups.CountryCodes;
import com.example.phone.directory.repository.CountryCodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryCodeService {

    @Autowired
    private CountryCodesRepository countryCodesRepository;

    public List<CountryCodes> getAllCountryCodes()
    {
       return countryCodesRepository.findAll();
    }
}
