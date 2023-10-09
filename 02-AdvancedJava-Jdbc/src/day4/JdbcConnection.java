package day4;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

	private JdbcConnection() {

	}

	public static Connection getConnection() throws SQLException, IOException {
		Connection connection = null;
		
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sagandhi\\Desktop\\Advanced Java\\02-AdvancedJava-Jdbc\\src\\day4\\properties\\jdbc.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String url = properties.getProperty("url");
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");

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
