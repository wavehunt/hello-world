package com.sankar.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sankar.spring.entity.Emp;
@RestController
public class HrController {
	
	@Autowired
	HrService service;
	
	@GetMapping(path="/hr/emp",produces="application/json")
	public ResponseEntity<Emp> processGetEmp(@RequestParam("id") int id){
		return service.getEmpDetails(id);
		
	}
	
	@GetMapping(path="/hr/list",produces="application/json")
	public ResponseEntity<List<Emp>> processEmpList(){
		return service.getAllEmps();
	}

}
