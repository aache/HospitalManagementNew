package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource; 
	

	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery(
	   "select username,password, enabled from users where username=?")
	  .authoritiesByUsernameQuery(
	   "select username, role from user_roles where username=?");
	 } 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeRequests()
	  .antMatchers("/production/index.html").access("hasRole('ROLE_ADMIN')")  
	  .anyRequest().permitAll()
	  .and()
	    .formLogin().loginPage("/production/login.html")
	    .usernameParameter("username").passwordParameter("password")
	    .defaultSuccessUrl("/production/index.html")
	    .failureUrl("/production/login.html?error=true")
	  .and()
	    .logout().logoutSuccessUrl("/production/login.html?logout") 
	   .and()
	   .exceptionHandling().accessDeniedPage("/403")
	  .and()
	    .csrf();
	 }

}
