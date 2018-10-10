package com.sankar.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sankar.spring.dao.EmpDao;
import com.sankar.spring.entity.Emp;

@Service
@Transactional
public class HrService {
	
	
	@Autowired
	//@Qualifier("empDaoJpaImpl")
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
	
	
	public void displayEmpInfo(int id) {
		Emp emp=dao.findById(id);
		System.out.println(emp.getEmpId() + " " + emp.getName() + " " + emp.getSalary());
	}
	
	public String deleteEmp(int id) {
		String resp=dao.delete(id);
		return resp;
	}
	
	public void getAllEmp() {
		dao.getAll().forEach(e->System.out.println(e.getName()));
	}
	
	public void showEmpList() {
		dao.getAll().stream().forEach(e->System.out.println(e.getEmpId() + " " + e.getName() + " " + e.getSalary()));
	}
	
}
