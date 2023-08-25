package com.ciq.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementInsert {
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher", "root", "9182794292");
//			ps=connection.prepareStatement("create table networkwifi(id int  unsigned unique,networks varchar(20) check(networks in('Airtel','Jio','idea','Bsnl')),sms_rates double unsigned,data_rates double unsigned,call_rates double unsigned)");
//			ps.execute();
			
			ps=connection.prepareStatement("INSERT INTO networkwifi values(?,?,?,?,?)");
//			ps.setInt(1, 1);
//			ps.setString(2, "Airtel");
//			ps.setDouble(3,100);
//			ps.setDouble(4, 2.5);
//			ps.setDouble(5, 1000.0);
//			ps.executeUpdate();
			
			ps.setInt(1, 5);
			ps.setString(2, "Airtel");
			ps.setDouble(3, 500);
			ps.setDouble(4, 3.5);
			ps.setDouble(5, 25000);
			ps.executeUpdate();
			
			
//			ps.addBatch("insert into networkwifi values(2,'Jio',150,2.0,15000)");
//			ps.addBatch("insert into networkwifi values(3,'idea',250,3.0,25000)");
//			ps.addBatch("insert into networkwifi values(4,'Bsnl',180,2.0,20000)");
		
			int arr[] =ps.executeBatch();
			for (int i : arr) {
				System.out.println(i);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
