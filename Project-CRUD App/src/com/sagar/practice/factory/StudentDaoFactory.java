package com.sagar.practice.factory;

import com.sagar.practice.dao.IStudentDao;
import com.sagar.practice.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static IStudentDao studentDao = null;
	
	private StudentDaoFactory() {
		
	}
	
	public static IStudentDao getStudentDao() {
		if (studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
}
