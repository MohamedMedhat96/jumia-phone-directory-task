package com.example.phone.directory.repository;

import com.example.phone.directory.model.lookups.CountryRegex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRegexRepository extends JpaRepository<CountryRegex, Long> {
}
