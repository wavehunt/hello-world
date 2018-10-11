package com.sankar.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sankar.spring.entity.Emp;
import com.sankar.spring.repo.EmpRepository;

@RestController
public class EmpController {
	@Autowired
	private EmpRepository repo;
	
	@RequestMapping(path="/info",method=RequestMethod.GET,produces="text/plain")
	public String info() {
		return "this is a sample REST service";
	}
	
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
	
	@RequestMapping(path="/emp/save",
					method=RequestMethod.POST,
					consumes="application/json",
					produces="text/plain")
	public String addEmp(@RequestBody Emp e) {
		if(repo.existsById(e.getEmpId())) {
			return "Emp already exists";
		} else
		{
			repo.save(e);
			return "Emp Save successfully!";
		}
	}
	
	@RequestMapping(path="/emp/update",
				method=RequestMethod.PUT,
				consumes="application/json",
				produces="text/plain")
	public String updateEmp(@RequestBody Emp e) {
		repo.save(e);
		return "Emp UPDATED successfully!";
	}	
	
	@RequestMapping(path="/emp/delete",
			method=RequestMethod.DELETE,
//			consumes="text/plain",
			produces="text/plain")
	public String deleteEmp(@RequestParam("id") int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Emp deleted";
		} else
		{
			return "Emp doesn't exist!";
		}
	}
	
	@RequestMapping(path="/emp/list",
			method=RequestMethod.GET,
//			consumes="text/plain",
//Another way to specify media 			
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> getEmpList(){
		return repo.findAll();
	}
}
