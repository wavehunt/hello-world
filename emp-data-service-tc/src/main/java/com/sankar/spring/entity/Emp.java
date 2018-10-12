package com.sankar.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Not managed by Spring, because this is data and not required to be
@Entity
@Table(name="EMP")
public class Emp {
	
	@Id
	@Column(name="EMPNO")
	private int empId;
	@Column(name="NAME")
	//If column name and filed name is same, then the above definition is optional
	private String name;
	@Column(name="ADDRESS")
	private String city;
	@Column(name="SALARY")
	private double salary;
	
	public Emp() {
		
	}

	public Emp(int empId, String name, String city, double salary) {
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	

}
