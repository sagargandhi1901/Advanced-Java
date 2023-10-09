package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TestApp {
	public static void main(String[] args) throws SQLException {
		
		// Step 1
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// Step 2
		String url = "jdbc:mysql://localhost:3306/practice";
		String userName = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		// Step 3
		Statement statement = connection.createStatement();
		
		// Step 4
		String query = "select id, name from demo";
		ResultSet resultSet = statement.executeQuery(query);
		
		// Step 5
		System.out.println("Number\tName");
		System.out.println("--------------");
		while (resultSet.next()) {
			int number = resultSet.getInt("id");
			String name = resultSet.getString(2);
			System.out.println(number + "\t" + name);
		}
		
		// Step 6
		connection.close();
	}
}