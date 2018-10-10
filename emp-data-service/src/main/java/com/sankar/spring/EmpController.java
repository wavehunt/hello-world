package com.sankar.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sankar.spring.entity.Emp;
import com.sankar.spring.repo.EmpRepository;

@RestController
public class EmpController {
	@Autowired
	private EmpRepository repo;
	
	@RequestMapping(path="/emp/{id}",method=RequestMethod.GET,produces="application/json")
	public Emp findEmpById(@PathVariable("id") int id) {
		Optional<Emp> o=repo.findById(id);
		if(o.isPresent()) {
			return o.get();
		}
		else
		{
			throw new RuntimeException("No Emp Found");
		}
	}
	

}
