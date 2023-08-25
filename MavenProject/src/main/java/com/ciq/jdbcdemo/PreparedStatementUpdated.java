package com.ciq.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementUpdated {
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement ps=null;
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher", "root", "9182794292");
		    ps=connection.prepareStatement("update networkwifi set networks= ? ,sms_rates= ?  where id= ? ");
		    ps.setInt(3, 2);
		    ps.setString(1, "Bsnl");
		    ps.setDouble(2, 350);
		    ps.executeUpdate();
		    
		    ps.addBatch("update networkwifi set networks='jio' where id=5");
		    ps.addBatch("alter table networkwifi add reg_date Date");
		    ps.addBatch("update networkwifi set reg_date='2015-06-2' where id=1");
		    ps.addBatch("update networkwifi set reg_date='2013-07-07' where id=2");
		    ps.addBatch("update networkwifi set reg_date='2012-08-05' where id=3");
		    ps.addBatch("update networkwifi set reg_date='2013-07-07' where id=4");
		    ps.addBatch("update networkwifi set reg_date='2012-08-05' where id=5");
		    
		    int arr[]=ps.executeBatch();
		    for (int i : arr) {
				System.out.println(i);
			}
		    
		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
