package com.sankar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sankar.spring.service.HrService;

public class UseDaoMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService service=ctx.getBean(HrService.class);
		
		//service.displayEmpInfo(110);
		
		//System.out.println(service.registerEmployee(108, "Sasi", "KPHB", 60000));
		//System.out.println(service.registerEmployee(109, "Sowji", "Nacharam", 70000));
		//System.out.println(service.registerEmployee(110, "Visu", "Amsterdam", 80000));
		
		//System.out.println(service.deleteEmp(108));
		
		//service.getAllEmp();
		
		service.showEmpList();
		
		
		

	}

}
