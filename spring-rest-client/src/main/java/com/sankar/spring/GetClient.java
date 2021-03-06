package com.sankar.spring;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sankar.spring.entity.Emp;

public class GetClient {

	public static void main(String[] args) {
		
		String userDetails="pavan:welcome1";
		String encodedCred = new String(Base64.encodeBase64(userDetails.getBytes()));
		
		RestTemplate rt = new RestTemplate();
		
		//-------------------------------
		// This is to GET an employee data
		//-------------------------------
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic " + encodedCred);
		HttpEntity req = new HttpEntity<>(headers);
		
		//ResponseEntity<String> resp=rt.exchange("http://localhost:8081/emp/109", HttpMethod.GET, req, String.class);
		//This is to convert json resp to Emp object
		//ResponseEntity<Emp> resp=rt.exchange("http://localhost:8081/emp/109", HttpMethod.GET, req, Emp.class);
		
		//exchange is a generic way to send the request to server
		//there are specific getForEntity/postForEntity etc as well
		
		ResponseEntity<List<Emp>> resp=rt.exchange("http://localhost:8081/emp/list", HttpMethod.GET, req, 
				//Cannot directly use List<Emp.class> here .. need to use below
				new ParameterizedTypeReference<List<Emp>>() {
		});
		
		//System.out.println(resp.getBody().getName());
		resp.getBody().stream().forEach(e->System.out.println(e.getName()+ " " + e.getCity()+ " " + e.getSalary()));
		
		
	}

}
