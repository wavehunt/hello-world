package com.sankar.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sankar.spring.dao.EmpDao;
import com.sankar.spring.entity.Emp;

@Service
public class HrService {
	
	@Autowired
	@Qualifier("empDaoJpaImpl")
	private EmpDao dao;
	
	/* When @Autorwired, this method is no more required
	 
	public void setDao(EmpDao dao) {
		this.dao=dao;
	}
	*/
	
	public String registerEmployee(int id,String name,String city,double salary) {
		String resp=dao.save(new Emp(id,name,city,salary));
		return resp;
	}

}
