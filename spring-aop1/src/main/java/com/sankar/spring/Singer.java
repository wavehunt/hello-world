package com.sankar.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Singer  implements Performer {
//public class Singer {
	
	/*
	@Autowired
	Audience audience;
	*/
	
	@Override
	public void perform() {
		/*
		audience.takeSeat();
		audience.switchOffMobile();
		*/
		
		System.out.println("Singer is now singing");
		
		/*
		audience.applaud();
		*/		
	}
	
	

}
