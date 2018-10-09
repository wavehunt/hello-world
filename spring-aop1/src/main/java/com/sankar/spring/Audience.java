package com.sankar.spring;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Audience {
	
	@Pointcut("execution(* com.sankar.spring.*.perf*(..))")
	private void pcut() {}
	
	@Before("pcut()")
	public void takeSeat() {
		System.out.println("Audience Taking Seats");
	}
	
	@Before("pcut()")
	public void switchOffMobile() {
		System.out.println("Audience Switching Off mobiles");
	}
	
	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("Good Singing.. Clap! Clap ! Clap!");
	}

}


