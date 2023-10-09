package day4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionManagement {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Scanner sc = null;

		try {
			connection = JdbcConnection.getConnection();
			
			statement = connection.createStatement();
			System.out.println("data before transaction : ");
			System.out.println("---------------------------");
			resultSet = statement.executeQuery("select name, balance from demo5");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getInt(2));
			}
			
			connection.setAutoCommit(false);
			statement.executeUpdate("update demo5 set balance = balance - 2000 where name = 'diksha'");
			statement.executeUpdate("update demo5 set balance = balance + 2000 where name = 'sagar'");
			sc = new Scanner(System.in);
			System.out.println("Please confirm the transaction :: ");
			String option = sc.next();
			if (option.equalsIgnoreCase("yes")) {
				connection.commit();
				System.out.println("Transaction commited");
			} else {
				connection.rollback();
				System.out.println("Transaction rollback");
			}
			
			System.out.println("data after transaction : ");
			System.out.println("---------------------------");
			resultSet1 = statement.executeQuery("select name, balance from demo5");
			while (resultSet1.next()) {
				System.out.println(resultSet1.getString(1) + "\t" + resultSet1.getInt(2));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					JdbcConnection.closeConnetion(connection);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}