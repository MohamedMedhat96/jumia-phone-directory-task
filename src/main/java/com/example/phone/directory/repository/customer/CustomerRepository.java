package com.example.phone.directory.repository.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.phone.directory.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public List<Customer> findbyState(Boolean state);

}
