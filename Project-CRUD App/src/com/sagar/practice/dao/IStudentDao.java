package com.sagar.practice.dao;

import com.sagar.practice.model.Student;

public interface IStudentDao {

	String save(Student student);

	Student findById(Integer sId);
	
	String updateById(Student student);
	
	String deleteById(Integer sId);
}
