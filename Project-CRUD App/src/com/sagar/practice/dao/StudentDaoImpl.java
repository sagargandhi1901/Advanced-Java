package com.sagar.practice.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sagar.practice.model.Student;
import com.sagar.practice.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;

	@Override
	public String save(Student student) {
		String sqlInsertQuery = "insert into student (name, email, city, country) values (?, ?, ?, ?)";
		String status = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlInsertQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, student.getName());
				prepareStatement.setString(2, student.getEmail());
				prepareStatement.setString(3, student.getCity());
				prepareStatement.setString(4, student.getCountry());
			}
			
			if (prepareStatement != null) {
				int rowAffected = prepareStatement.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (SQLException | IOException e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student findById(Integer sId) {
		String sqlSelectQuery = "select sid, name, email, city, country from student where sid = ?";
		Student student = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlSelectQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setInt(1, sId);
			}
			
			if (prepareStatement != null) {
				ResultSet result = prepareStatement.executeQuery();
				if (result.next()) {
					student = new Student();
					student.setsId(result.getInt(1));
					student.setName(result.getString(2));
					student.setEmail(result.getString(3));
					student.setCity(result.getString(4));
					student.setCountry(result.getString(5));
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateById(Student student) {
		String sqlUpdateQuery = "update student set name = ?, email = ?, city = ?, country = ? where sid = ?";
		String status = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, student.getName());
				prepareStatement.setString(2, student.getEmail());
				prepareStatement.setString(3, student.getCity());
				prepareStatement.setString(4, student.getCountry());
				prepareStatement.setInt(5, student.getsId());
			}
			
			if (prepareStatement != null) {
				int rowAffected = prepareStatement.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (SQLException | IOException e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteById(Integer sId) {
		String sqldeleteQuery = "delete from student where sid = ?";
		String status = null;
		PreparedStatement prepareStatement = null;
		
		try {
			Student student = findById(sId);
			if (student != null) {
				connection = JdbcUtil.getConnection();
				if (connection != null) {
					prepareStatement = connection.prepareStatement(sqldeleteQuery);
				}
				if (prepareStatement != null) {
					prepareStatement.setInt(1, sId);
				}
				
				if (prepareStatement != null) {
					int rowAffected = prepareStatement.executeUpdate();
					if (rowAffected == 1) {
						status = "success";
					} else {
						status = "failure";
					}
				}
			} else {
				status = "not available";
			}
			
		} catch (SQLException | IOException e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}
}