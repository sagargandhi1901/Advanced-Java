package com.sagar.practice.service;

import com.sagar.practice.dao.IStudentDao;
import com.sagar.practice.factory.StudentDaoFactory;
import com.sagar.practice.model.Student;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao;
	
	@Override
	public String save(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.save(student);
	}

	@Override
	public Student findById(Integer sId) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.findById(sId);
	}

	@Override
	public String updateById(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sId) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(sId);
	}
}
