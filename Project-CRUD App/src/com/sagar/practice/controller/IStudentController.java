package com.sagar.practice.controller;

import com.sagar.practice.model.Student;

public interface IStudentController {

	String save(Student student);

	Student findById(Integer sId);
	
	String updateById(Student student);
	
	String deleteById(Integer sId);
}
