package com.sankar.spring.dao;

import org.springframework.stereotype.Repository;

import com.sankar.spring.entity.Emp;

@Repository
public class EmpDaoJpaImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		System.out.println("JPA: Saved the Employee");
		return "Success";
	}
	
	
	

}
