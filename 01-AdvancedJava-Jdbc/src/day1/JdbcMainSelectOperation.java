package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMainSelectOperation {
	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String url = "jdbc:mysql://localhost:3306/practice";
		String userName = "root";
		String password = "root";

		try {
			connection = DriverManager.getConnection(url, userName, password);
			if (connection != null) {
				statement = connection.createStatement();
				if (statement != null) {
					String query = "select id, name from demo";
					resultSet = statement.executeQuery(query);
					if (resultSet != null) {
						System.out.println("Number\tName");
						System.out.println("--------------");
						while (resultSet.next()) {
							int number = resultSet.getInt("id");
							String name = resultSet.getString(2);
							System.out.println(number + "\t" + name);
						}
					}
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