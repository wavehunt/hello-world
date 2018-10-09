package com.sankar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		Performer p = (Performer) ctx.getBean("singer");
		//Singer p =  (Singer) ctx.getBean("singer");

		//actually, this is calling the proxy
		p.perform();
		
		/*
		System.out.println(p.getClass().getName());
		
		Class<?>[] intfs = p.getClass().getInterfaces();
		for(Class<?> c:intfs) {
			System.out.println(c.getName());
		}
		*/

	}

}
