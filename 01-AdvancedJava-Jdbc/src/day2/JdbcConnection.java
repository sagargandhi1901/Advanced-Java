package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	private JdbcConnection() {

	}

	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/practice";
		String userName = "root";
		String password = "root";

		connection = DriverManager.getConnection(url, userName, password);
		if (connection != null) {
			return connection;
		}
		return connection;
	}

	public static void closeConnetion(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}
