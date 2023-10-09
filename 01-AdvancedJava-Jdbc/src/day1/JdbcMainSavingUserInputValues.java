package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcMainSavingUserInputValues {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		String url = "jdbc:mysql://localhost:3306/practice";
		String userName = "root";
		String password = "root";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the jersey number of player : ");
		int id = scanner.nextInt();
		System.out.println("Enter the name of player : ");
		String name = scanner.next();

		try {
			connection = DriverManager.getConnection(url, userName, password);
			if (connection != null) {
				statement = connection.createStatement();
				if (statement != null) {
//					String query = "insert into demo (id, name) values ("+ id + ", '"+ name + "')";
					String query = String.format("insert into demo (id, name) values(%d, '%s')", id, name);
					System.out.println("Executing :: " + query);
					int numberOfRows = statement.executeUpdate(query);
					System.out.println("Number of rows affected : " + numberOfRows);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}