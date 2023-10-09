package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CLOBInsertOpeartions {
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		FileReader reader = null;

		try {
			connection = JdbcConnection.getConnection();
			if (connection != null) {
				String query = "insert into demo4 (name, details) values (?, ?)";
				prepareStatement = connection.prepareStatement(query);
				if (prepareStatement != null) {
					// text file reaching to java application
					File f = new File("details_about_city.txt");
					reader = new FileReader(f);
					
					prepareStatement.setString(1, "Delhi");

					// taking the input information and sending to database
					prepareStatement.setCharacterStream(2, reader);

					System.out.println("Inserting text file from : " + f.getAbsolutePath());

					int rows = prepareStatement.executeUpdate();
					if (rows == 1) {
						System.out.println("Record inserted successfully...");
					} else {
						System.out.println("no record added...");
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException e) {
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