package com.sagar.practice.model;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 8417255607955508450L;
	
	private Integer sId;
	private String name;
	private String email;
	private String city;
	private String country;	
	
	static {
		System.out.println("Student.class is loading...");
	}
	
	public Student() {
		System.out.println("Student object created...");
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + ", email=" + email + ", city=" + city + ", country=" + country
				+ "]";
	}
}