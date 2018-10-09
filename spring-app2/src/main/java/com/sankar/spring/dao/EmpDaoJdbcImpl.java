package com.sankar.spring.dao;

import com.sankar.spring.entity.Emp;

public class EmpDaoJdbcImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		System.out.println("Saved the Employee");
		return "Success";
	}
	
	
	

}
