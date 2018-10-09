package com.sankar.spring.dao;

import org.springframework.stereotype.Repository;

import com.sankar.spring.entity.Emp;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		System.out.println("JDBC: Saved the Employee");
		return "Success";
	}
	
	
	

}
