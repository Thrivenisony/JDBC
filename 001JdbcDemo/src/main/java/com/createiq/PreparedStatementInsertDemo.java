package com.createiq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.createiq.util.ConnectionUtil;

public class PreparedStatementInsertDemo {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionUtil.getConnection();
		    ps = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?)");
		    ps.setInt(1, 16);
		    ps.setString(2, "Abhi");
		    ps.setDouble(3, 30000.00);
		    
		    ps.executeUpdate();
		    
		    System.out.println("Success");
		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, connection);
		}

	}

}
