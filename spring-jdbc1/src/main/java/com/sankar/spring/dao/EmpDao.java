package com.sankar.spring.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sankar.spring.entity.Emp;


public interface EmpDao {
	
	public String save(Emp e);
	
	public String delete(int id);
	
	public Emp findById(int id);
	
	public List<Emp> getAll();
	
	
}
