package com.createiq;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.createiq.util.ConnectionUtil;

public class DateDemo {
	
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?)");
			preparedStatement.setInt(1, 1001);
			preparedStatement.setString(2, "Balaji");
			preparedStatement.setDouble(3, 200000.00);
			java.util.Date utilDate = new java.util.Date();
			Date sqldate = new Date(utilDate.getTime());
			preparedStatement.setDate(4, sqldate);
			preparedStatement.executeUpdate();
			System.out.println("Success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
