package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMainUpdateOperation {
	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		String url = "jdbc:mysql://localhost:3306/practice";
		String userName = "root";
		String password = "root";

		try {
			connection = DriverManager.getConnection(url, userName, password);
			if (connection != null) {
				statement = connection.createStatement();
				if (statement != null) {
					String query = "update demo set name = 'Virat Kohli' where id = 18";
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
		}
	}
}