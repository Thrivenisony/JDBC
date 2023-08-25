package com.ciq.transactionmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ciq.jdbcutil.ConnectionUtill;

public class EmployeTransactionManagement {
	public static void main(String[] args) {
		Connection connection=null;
		connection=ConnectionUtill.getConnection();
		PreparedStatement preInsert =null;
		PreparedStatement preUpdate =null;
		String insertQuyery = "insert into playersname values(?,?,?,?,?)";
		String updateQuyery = "update  playersname set name=?, trophy=?, jersynumber=?, score=? where id=?";
		
		try {
			preInsert= connection.prepareStatement(insertQuyery);
			preUpdate= connection.prepareStatement(updateQuyery);
			
			
			
			preInsert.setInt(5, 100);
			preInsert.setString(1, "laxmi");
			preInsert.setString(2, "20");
			preInsert.setInt(3, 33);
			preInsert.setInt(4, 200);
			
			
			preInsert.addBatch();
			
			preUpdate.setInt(5, 4);
			preUpdate.setString(1, "Thriveni");
			preUpdate.setString(2, "10");
			preUpdate.setInt(3, 13);
			preUpdate.setInt(4, 100);
			
			preUpdate.executeBatch();
			preInsert.executeBatch();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionUtill.close(connection);
			try {
				preInsert.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				preUpdate.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

		
		
		
	}


