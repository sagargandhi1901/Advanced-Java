package day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		PreparedStatement prpStmt = null;
		ResultSet resultSet = null;
//		String query = "select id, name from demo where id = ? or name = ?";
		String query = "select id, name from demo where id = ?";

		try {
			connection = JdbcConnection.getConnection();
			if (connection != null) {
				prpStmt = connection.prepareStatement(query);
				if (prpStmt != null) {
					prpStmt.setInt(1, 18);
//					prpStmt.setString(2, "Ashwin");
					resultSet = prpStmt.executeQuery();
					if (resultSet != null) {
						if (resultSet.next()) {
							System.out.println("Number\tName");
							System.out.println("--------------");
							int number = resultSet.getInt("id");
							String name = resultSet.getString(2);
							System.out.println(number + "\t" + name);
						} else {
							System.out.println("Record not available....");
						}
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcConnection.closeConnetion(connection);
		}
	}
}