package com.sankar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sankar.spring.service.HrService;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		//Normal method
		//HrService hr=(HrService) ctx.getBean("hrService");
		
		//Alternative Way
		HrService hr=ctx.getBean(HrService.class);
		
		System.out.println(hr.registerEmployee(100, "James", "London", 90000));

	}

}
