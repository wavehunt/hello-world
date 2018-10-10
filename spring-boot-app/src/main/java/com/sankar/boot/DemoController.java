package com.sankar.boot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	//@RequestMapping(path="/greet",method=RequestMethod.GET,produces="text/plain")
	//@RequestMapping(path="/greet/{name}",method=RequestMethod.GET,produces="text/plain")
	@RequestMapping(path="/greet",method=RequestMethod.GET,produces="text/plain")

	
	public String greet(@RequestParam("name") String n) {
		
		return "Welcome to Spring REST, " + n ;
	}

}
