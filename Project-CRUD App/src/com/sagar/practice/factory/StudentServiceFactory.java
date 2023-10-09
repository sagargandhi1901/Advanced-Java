package com.sagar.practice.factory;

import com.sagar.practice.service.IStudentService;
import com.sagar.practice.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private static IStudentService studentService = null;
	
	private StudentServiceFactory() {
		
	}
	
	public static IStudentService getStudentService() {
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

}
