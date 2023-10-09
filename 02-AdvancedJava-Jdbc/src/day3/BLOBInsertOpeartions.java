package day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BLOBInsertOpeartions {
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		FileInputStream fis = null;

		try {
			connection = JdbcConnection.getConnection();
			if (connection != null) {
				String query = "insert into demo3 (name, image) values (?, ?)";
				prepareStatement = connection.prepareStatement(query);
				if (prepareStatement != null) {
					// Image file reaching to java application
					File f = new File("myphoto.jpg");
					fis = new FileInputStream(f);

					prepareStatement.setString(1, "Sagar");

					// taking the input information and sending to database
					prepareStatement.setBlob(2, fis);

					System.out.println("Inserting image from : " + f.getAbsolutePath());

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