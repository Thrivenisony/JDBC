package com.ciq.jdbcutill;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtill {
	private static Properties properties=null;
	static {
		properties=new Properties();
		try {
			properties.load(ConnectionUtill.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		Class.forName(properties.getProperty("driver"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 public static Connection getConnection() {
		 Connection connection=null;
		 try {
			connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("uname"),properties.getProperty("pw"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return connection;
	 }
	 
	 public static void close(Connection connection) {
		 try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static void main(String[] args) {
		 
		System.out.println(getConnection());
		
	}
		

}
