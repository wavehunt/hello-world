package com.sankar.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sankar.spring.entity.Emp;

public class PostClient {

	public static void main(String[] args) {
		
		RestTemplate rt = new RestTemplate();
		
		//-------------------------------
		// This is to SAVE a new employee
		//-------------------------------
		Emp emp = new Emp(124,"Chat","Meerpet", 110000);
				
		HttpHeaders headers1 = new HttpHeaders();
		headers1.set("Accept", "text/plain");
		headers1.set("Content-Type", "application/json");
		
		HttpEntity req1 = new HttpEntity<>(emp,headers1);
		
		ResponseEntity<String> resp1=rt.exchange("http://localhost:8081/emp/save", HttpMethod.POST, req1, 
				
				String.class);
		
		System.out.println(resp1.getBody());		

	}

}
