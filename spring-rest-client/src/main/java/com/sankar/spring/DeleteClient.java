package com.sankar.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sankar.spring.entity.Emp;

public class DeleteClient {

	public static void main(String[] args) {
		
		RestTemplate rt = new RestTemplate();
		
		//-------------------------------
		// This is to DELETE an existing employee
		//-------------------------------
						
		HttpHeaders headers1 = new HttpHeaders();
		headers1.set("Accept", "text/plain");
		headers1.set("Content-Type", "text/plain");
		
		HttpEntity req1 = new HttpEntity<>(headers1);
		
		ResponseEntity<String> resp1=rt.exchange("http://localhost:8081/emp/delete?id=121", HttpMethod.DELETE, req1, 
				
				String.class);
		
		System.out.println(resp1.getBody());		

	}

}
