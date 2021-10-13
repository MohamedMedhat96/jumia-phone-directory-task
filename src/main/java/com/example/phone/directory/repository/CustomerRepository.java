package com.example.phone.directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.phone.directory.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
