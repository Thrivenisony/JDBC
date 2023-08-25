package com.ciq.jdbcdemo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		 
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cricketplayers","root","9182794292");
	        //String sql="CREATE TABLE playersname("+"id INT UNIQUE,"+"name VARCHAR(50)"+")"; 
			statement=connection.createStatement();
	       
	        //statement.execute(sql);
//	        statement.addBatch("INSERT INTO playersname VALUES (7,'Ms Dhoni')");
//	        statement.addBatch("INSERT INTO playersname VALUES(18,'Virat kholi')");
//	        statement.addBatch("INSERT INTO playersname VALUES(45,'Rohit Sharma')");
	       // statement.addBatch("ALTER TABLE playersname add trophy VARCHAR(50)");
	        //statement.addBatch("ALTER TABLE playersname add jersynumber int");
	        //statement.addBatch("UPDATE playersname set id=1 where name='Ms Dhoni'");
	        //statement.addBatch("ALTER TABLE playersname add score INT UNIQUE");
//	        statement.addBatch("UPDATE playersname set id=2 where name='Virat kholi'");
//	        statement.addBatch("UPDATE playersname set id=3 where name='Rohit Sharma'");
//	        statement.addBatch("update playersname set jersynumber=7,trophy=8,score=100 where id=1 ");
//	        statement.addBatch("update playersname set jersynumber=18,trophy=5,score=99 where id=2");
//	        statement.addBatch("update playersname set jersynumber=45,trophy=8,score=98 where id=3");
//	        statement.addBatch("insert into playersname values (4,'Sachin',15,10,200)");
	        statement.addBatch("delete from playersname where id=4");
	        int arr[] =statement.executeBatch();
	        for (int i : arr) {
				System.out.println(i);
			}
			System.out.println("success"+statement);
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
