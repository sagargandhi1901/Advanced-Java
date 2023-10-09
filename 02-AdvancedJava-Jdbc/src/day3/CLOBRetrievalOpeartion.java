package day3;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;

public class CLOBRetrievalOpeartion {
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Reader reader = null;
		FileWriter writer = null;

		try {
			connection = JdbcConnection.getConnection();
			if (connection != null) {
				String query = "select name, details from demo4 where name = ?";
				prepareStatement = connection.prepareStatement(query);
				if (prepareStatement != null) {
					String city = "Delhi";
					prepareStatement.setString(1, city);
					resultSet = prepareStatement.executeQuery();

					if (resultSet != null) {
						if (resultSet.next()) {
							
							// fetching the city name
							String nameFromDb = resultSet.getString(1);
							
							// fetching the text file and keeping in hard disk like downloading
							reader = resultSet.getCharacterStream(2);
							String fileName = "delhi_details_download.txt";
							File file = new File(fileName);
							writer = new FileWriter(file);
							
							IOUtils.copy(reader, writer);
							writer.flush();
							System.out.println("Name : " + nameFromDb);
							System.out.println("File is saved at location : " + file.getAbsolutePath());
						} else {
							System.out.println("Record not available for city : " + city);
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
				try {
					JdbcConnection.closeConnetion(connection);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}