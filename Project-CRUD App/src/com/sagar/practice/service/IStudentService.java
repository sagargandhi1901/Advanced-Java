package com.sagar.practice.service;

import com.sagar.practice.model.Student;

public interface IStudentService {
	
	String save(Student student);

	Student findById(Integer sId);
	
	String updateById(Student student);
	
	String deleteById(Integer sId);
}
