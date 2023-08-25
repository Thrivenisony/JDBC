package com.ciq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Driver;

public class JdbcDemo {
public static void main(String[] args) {
	Connection connection=null;
	Statement statement=null;
	try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		
		
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root","9182794292");
		statement=connection.createStatement();
		System.out.println(connection);
//		int rowsUpdated=statement.executeUpdate("INSERT INTO person VALUES(10,'adhithya',20000)");
//		int rowsUpdatedd= statement.executeUpdate("UPDATE person set fname='adhi' where id=10");
//		int rows=statement.executeUpdate("alter table person add constraint unique u_id(id)");
//		System.out.println("row updated:"+rowsUpdatedd);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	} catch (Exception e) {
	
		e.printStackTrace();
	} 
}


}
