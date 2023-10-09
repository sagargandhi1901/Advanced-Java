package com.sagar.practice.factory;

import com.sagar.practice.controller.IStudentController;
import com.sagar.practice.controller.StudentControllerImpl;

public class StudentControllerFactory {

	private static IStudentController studentController = null;
	
	private StudentControllerFactory() {
		
	}
	
	public static IStudentController getStudentController() {
		
		if (studentController == null) {
			studentController = new StudentControllerImpl();
		}
		return studentController;
	}
}
