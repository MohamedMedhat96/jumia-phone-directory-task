package com.example.phone.directory.repository.customer;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.phone.directory.model.country.Country;
import com.example.phone.directory.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public Page<Customer> findByPhoneNumberState(Boolean state, Pageable pageable);
	
	@Query(value = "SELECT * FROM Customer c where c.country_id = ?1", 
			countQuery = "select count(*) FROM Customer c where c.country_id = ?1 ",
			nativeQuery = true)
	public Page<Customer> findByCountryId(Long id, Pageable pageable);
}
