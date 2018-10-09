package com.sankar.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.sankar.spring")
@EnableTransactionManagement
public class DaoConfig {

	@Bean("ds")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}
	
	@Bean("ds1")
	public DriverManagerDataSource dataSource1() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jt(@Qualifier("ds1") DataSource ds) {
		System.out.println(ds.getClass());
		
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(@Qualifier("ds1") DataSource ds) {
		DataSourceTransactionManager txm=new DataSourceTransactionManager(ds);
		return txm;
	}
}
