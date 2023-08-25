package com.createiq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementUpdateDemo2 {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher", "root", "9182794292");
		    ps = connection.prepareStatement("UPDATE PERSON SET FNAME = ?, SALARY = ? WHERE ID = ?");
		    ps.setInt(3, 15);
		    ps.setString(1, "Abhiram");
		    ps.setDouble(2, 20000.00);
		    
		    ps.executeUpdate();
		    
		    System.out.println("Success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
