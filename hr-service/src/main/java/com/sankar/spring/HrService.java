package com.sankar.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sankar.spring.entity.Emp;

@Service
public class HrService {
	
	@Autowired
	RestTemplate rt;
	
	public ResponseEntity<Emp> getEmpDetails(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		
		HttpEntity req = new HttpEntity<>(headers);
		
		ResponseEntity<Emp> resp=rt.exchange("http://localhost:8081/emp/"+id, HttpMethod.GET, req,Emp.class);
		return resp;
		
	}
	
	public ResponseEntity<List<Emp>> getAllEmps() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		
		HttpEntity req = new HttpEntity<>(headers);
		
		ResponseEntity<List<Emp>> resp=rt.exchange("http://localhost:8081/emp/list", HttpMethod.GET, req,
				//Cannot directly use List<Emp.class> here .. need to use below
				new ParameterizedTypeReference<List<Emp>>() {
		});
		return resp;
		
	}

}
