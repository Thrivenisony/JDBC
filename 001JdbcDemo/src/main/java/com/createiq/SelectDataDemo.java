package com.createiq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.createiq.util.ConnectionUtil;

public class SelectDataDemo {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM PERSON");
			while(rs.next()) {
			  int id = rs.getInt("id");
			  String name = rs.getString("fname");
			  double sal = rs.getDouble("salary");
			  System.out.println(id+" "+name+" "+sal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(statement, connection);
		}

	}

}
