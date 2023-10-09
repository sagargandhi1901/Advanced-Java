package com.sagar.practice.controller;

import com.sagar.practice.factory.StudentServiceFactory;
import com.sagar.practice.model.Student;
import com.sagar.practice.service.IStudentService;

public class StudentControllerImpl implements IStudentController {
	
	IStudentService studentService;

	@Override
	public String save(Student student) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.save(student);
	}

	@Override
	public Student findById(Integer sId) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.findById(sId);
	}

	@Override
	public String updateById(Student student) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.updateById(student);
	}

	@Override
	public String deleteById(Integer sId) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.deleteById(sId);
	}

}
