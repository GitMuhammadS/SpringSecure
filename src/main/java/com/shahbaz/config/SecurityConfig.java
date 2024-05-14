package com.shahbaz.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("raja").password("rani").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("badshah").password("begum").roles("MANAGER");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/").permitAll()
		.antMatchers("/offers").authenticated()
		.antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER")
		.antMatchers("loanApprove").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.exceptionHandling().accessDeniedPage("/denied");
		
	}
}
