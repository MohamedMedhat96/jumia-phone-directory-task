package com.example.phone.directory.repository;

import com.example.phone.directory.model.lookups.CountryCodes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryCodesRepository extends JpaRepository<CountryCodes, Long> {
}
