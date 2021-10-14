package com.example.phone.directory.configurations.database.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import com.example.phone.directory.helper.validator.PhoneNumberValidator;
import com.example.phone.directory.model.customer.Customer;
import com.example.phone.directory.repository.country.CountryRepository;
import com.example.phone.directory.repository.customer.CustomerRepository;
import com.example.phone.directory.service.country.CountryService;

import java.util.List;

import javax.sql.DataSource;

@Component
public class InitializeData {

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    CountryService countryService;

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("data.sql"));
        resourceDatabasePopulator.execute(dataSource);
        
        ResourceDatabasePopulator addColumn = new ResourceDatabasePopulator(true, true, "UTF-8", new ClassPathResource("add_column.sql")  );
        addColumn.execute(dataSource);
        boolean shouldSave = true;
        List<Customer> customers = customerRepository.findAll();
        for(Customer customer : customers) {
        	if(customer.getPhoneNumber().getState() ==null) {
        		customer.getPhoneNumber().setState(countryService.getCountryByPhoneNumber(customer.getPhoneNumber().getNumber())!=null);
        	}
        	else {
        		shouldSave = false;
        		break;
        	}
        }
        if(shouldSave)
        	customerRepository.saveAll(customers);
    }
}