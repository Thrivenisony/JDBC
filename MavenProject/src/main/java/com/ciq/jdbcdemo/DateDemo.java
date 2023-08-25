package com.ciq.jdbcdemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ciq.jdbcutil.ConnectionUtill;

public class DateDemo {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		connection = ConnectionUtill.getConnection();
		try {
			ps = connection.prepareStatement("update person set doj = ? where doj is null");
			java.util.Date utildate = new java.util.Date();
			Date sqlDate = new Date(utildate.getTime());
			ps.setDate(1, sqlDate);
			ps.executeUpdate();
			System.out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(ps, connection);
		}
	}
}
