package com.sankar.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
//@EnableWebSecurity -- not required in boot
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//super.configure(http);
		//permit all users to access info page
		//restrict anything with /emp/.. to match the role with USER/ADMIN only.. all others will be rejected
		//401 - invalid user - not authenticated
		//403 - valid user , but not authorized to access this page
		
		http.authorizeRequests().antMatchers("/info").permitAll()
		.antMatchers("/emp/**").hasAnyRole("USER","ADMIN").and().httpBasic().and().csrf().disable();
		
	}
	
	//This is for in-memory auth
	/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println(encoder().encode("welcome1"));
		auth.inMemoryAuthentication().withUser("sankar").password(encoder().encode("welcome1")).roles("USER");
		auth.inMemoryAuthentication().withUser("pavan").password(encoder().encode("welcome1")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("arun").password(encoder().encode("welcome1")).roles("CLIENT");
	}
	*/
	
	//This is for mysql database auth
	@Autowired
	DataSource ds;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds)
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
