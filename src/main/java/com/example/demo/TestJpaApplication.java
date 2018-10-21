package com.example.demo;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TestJpaApplication {
	 @Autowired
	  private Environment env;

	  @Bean
	  public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource(); 
	    dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	    dataSource.setUrl(env.getProperty("spring.datasource.url"));
	    dataSource.setUsername(env.getProperty("spring.datasource.username"));
	    dataSource.setPassword(env.getProperty("spring.datasource.password"));
	    return dataSource;
	  }
	
	
	public static void main(String[] args) {
		SpringApplication.run(TestJpaApplication.class, args);
	}
}
