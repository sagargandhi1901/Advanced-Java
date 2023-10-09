package day3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BLOBRetrievalOpeartion {
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		InputStream fis = null;
		FileOutputStream fos = null;

		try {
			connection = JdbcConnection.getConnection();
			if (connection != null) {
				String query = "select name, image from demo3 where name = ?";
				prepareStatement = connection.prepareStatement(query);
				if (prepareStatement != null) {
					String name = "Sagar";
					prepareStatement.setString(1, name);
					resultSet = prepareStatement.executeQuery();

					if (resultSet != null) {
						if (resultSet.next()) {
							
							// fetching the name
							String nameFromDb = resultSet.getString(1);
							
							// fetching the image and keeping in hard disk like downloading
//							Blob blob = resultSet.getBlob(2);
							fis = resultSet.getBinaryStream(2);
							String fileName = "sagar_downloaded_photo.jpg";
							File file = new File(fileName);
							fos = new FileOutputStream(file);
							
//							IOUtils.copy(fis, fos);
							
							byte[] buffer = new byte[5000];
							while (fis.read(buffer) != -1) {
								fos.write(buffer);
							}
							fos.flush();
							System.out.println("Name : " + nameFromDb);
							System.out.println("File is saved at location : " + file.getAbsolutePath());
//							System.out.println("Image : " + blob);
						} else {
							System.out.println("Record not available for name : " + name);
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
					fos.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}