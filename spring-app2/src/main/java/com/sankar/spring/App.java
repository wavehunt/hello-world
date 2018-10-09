package com.sankar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sankar.spring.service.HrService;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		HrService hr=(HrService) ctx.getBean("hr");
		
		System.out.println(hr.registerEmployee(100, "James", "London", 90000));

	}

}
