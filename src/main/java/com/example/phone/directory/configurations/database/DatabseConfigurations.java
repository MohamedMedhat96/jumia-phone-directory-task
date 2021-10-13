package com.example.phone.directory.configurations.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:persistence.properties")
@EnableJpaRepositories("com.example.phone.directory.repository")
public class DatabseConfigurations {
	
	@Autowired Environment env;

	@Bean
	public DataSource dataSource() {
	    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("driverClassName"));
	    dataSource.setUrl(env.getProperty("url"));
	    return dataSource;
	}

}
