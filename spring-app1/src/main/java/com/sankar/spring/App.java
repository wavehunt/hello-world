package com.sankar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		Mail mail = (Mail) ctx.getBean("mail");
		
		System.out.println("Header : " + mail.getMessage().getHeader());
		System.out.println("Body   : " + mail.getMessage().getBody());
		
		Mail mail1 = (Mail) ctx.getBean("mail");
		
		System.out.println("Header : " + mail1.getMessage().getHeader());
		System.out.println("Body   : " + mail1.getMessage().getBody());
		
		System.out.println(mail==mail1);

	}

}
