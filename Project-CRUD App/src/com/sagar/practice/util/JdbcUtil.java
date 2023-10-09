package com.sagar.practice.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// Using hikaricp configuration for connection pooling
public class JdbcUtil {

	private JdbcUtil() {

	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException, IOException {
		HikariConfig config = new HikariConfig("src\\com\\sagar\\practice\\properties\\db.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		// Connection connection = physicalConnection();
		Connection connection = dataSource.getConnection();
		return connection;
	}

	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws SQLException, IOException {
		FileInputStream fis = new FileInputStream("src\\com\\sagar\\practice\\properties\\db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
