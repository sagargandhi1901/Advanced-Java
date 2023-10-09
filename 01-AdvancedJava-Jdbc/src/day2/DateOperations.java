package day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateOperations {
	public static void main(String[] args) throws ParseException {
		
		Connection connection = null;
		PreparedStatement prStmt = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name : ");
		String name = sc.next();
		System.out.println("Enter the date of birth (dd-MM-yyyy) : ");
		String dob = sc.next();
		
		String datePattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
		Date utilDate = simpleDateFormat.parse(dob);
		long time = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(time);
		System.out.println("String date is : " + dob);
		System.out.println("util date is : " + utilDate);
		System.out.println("sql date is : " + sqlDate);
		
		try {
			connection = JdbcConnection.getConnection();
			
			// inserting date
			String query = "insert into demo2(name, dob) values (?, ?)";
			if (connection != null) {
				prStmt = connection.prepareStatement(query);
				if (prStmt != null) {
					prStmt.setString(1, name);
					prStmt.setDate(2, sqlDate);
					
					int rowsAffected = prStmt.executeUpdate();
					System.out.println("Number of rows affected : " + rowsAffected);
				}
			}
			
			// Retrieving date
			String query2 = "select dob from demo2 where name = ?";
			if (connection != null) {
				prStmt = connection.prepareStatement(query2);
				if (prStmt != null) {
					prStmt.setString(1, "Sagar");
					resultSet = prStmt.executeQuery();
					if (resultSet != null) {
						if (resultSet.next()) {
							java.sql.Date fetchedDate = resultSet.getDate(1);
							SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
							String newDate = simpleDateFormat2.format(fetchedDate);
							System.out.println(newDate);
						} else {
							System.out.println("Record not available....");
						}
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				JdbcConnection.closeConnetion(connection);
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}