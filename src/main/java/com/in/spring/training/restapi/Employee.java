package com.in.spring.training.restapi;


public class Employee {
	
	private Long empid;
	private int age;
	private String forename;
	private String surname;
	private String postcode;
	
	
	
	public Employee(Long i,int age, String forename, String surname, String postcode) {
		super();
		this.empid = i;
		this.age = age;
		this.forename = forename;
		this.surname = surname;
		this.postcode = postcode;
	}
	
	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	}
	
	
	

