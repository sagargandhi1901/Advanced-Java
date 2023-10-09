package day4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class ConnectionPoolingDemo {
	public static void main(String[] args) throws SQLException {
		
		// creating a pool 
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/practice");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		// logical connection bought from connection pool
		Connection connection = dataSource.getConnection();
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select id, name from demo where id = 7 or id = 18");
		
		System.out.println("NUMBER\tNAME");
		System.out.println("-----------------");
		while (resultSet.next()) {
			int number = resultSet.getInt(1);
			String name = resultSet.getString(2);
			System.out.println(number + "\t" + name);
		}
		
		// sending the connection object back to connection pool
		connection.close();
	}
}