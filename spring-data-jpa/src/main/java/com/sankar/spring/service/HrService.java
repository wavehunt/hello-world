package com.sankar.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sankar.spring.entity.Emp;
import com.sankar.spring.repo.EmpRepository;

@Service
@Transactional
public class HrService {
	
	
	@Autowired
	//@Qualifier("empDaoJpaImpl")
	private EmpRepository repo;
	
	/* When @Autorwired, this method is no more required
	 
	public void setDao(EmpDao dao) {
		this.dao=dao;
	}
	*/
	
	
	public String registerEmployee(int id,String name,String city,double salary) {
		Emp e=repo.save(new Emp(id,name,city,salary));
		return "saved";
	}
	
	
	public void displayEmpInfo(int id) {
		Optional<Emp> o=repo.findById(id);
		if(o.isPresent()) {
			Emp emp=o.get();
			System.out.println(emp.getEmpId() + " " + emp.getName() + " " + emp.getSalary());
		} else
		{
			System.out.println("no data found");
		}
		
	}
	
	public String deleteEmp(int id) {
		repo.deleteById(id);
		return "deleted";
	}
	/*
	public void getAllEmp() {
		dao.getAll().forEach(e->System.out.println(e.getName()));
	}
	*/
	
	public void showEmpList() {
		repo.findAll().stream().forEach(e->System.out.println(e.getEmpId() + " " + e.getName() + " " + e.getSalary()));
	}
	
	public void listWithSalaryRange(double s1,double s2){
		repo.getEmpWithSalaryBetweenRange(s1, s2).stream().forEach(e->System.out.println(e.getEmpId() + " " + e.getName() + " " + e.getSalary()));
		
	}
	
}
