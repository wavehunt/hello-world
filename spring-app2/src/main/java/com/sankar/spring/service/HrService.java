package com.sankar.spring.service;

import com.sankar.spring.dao.EmpDao;
import com.sankar.spring.entity.Emp;

public class HrService {
	
	private EmpDao dao;
	
	public void setDao(EmpDao dao) {
		this.dao=dao;
	}
	
	public String registerEmployee(int id,String name,String city,double salary) {
		String resp=dao.save(new Emp(id,name,city,salary));
		return resp;
	}

}
