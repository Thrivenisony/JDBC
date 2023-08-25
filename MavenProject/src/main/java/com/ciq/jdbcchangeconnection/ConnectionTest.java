package com.ciq.jdbcchangeconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ciq.jdbcutil.ConnectionUtill;

public class ConnectionTest {
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement ps=null;
		
		
		connection=ConnectionUtill.getConnection();
		try {
			ps=connection.prepareStatement("insert into playersname values(?,?,?,?,?)");
		ps.setInt(1, 4);
		ps.setString(2, "Sachin");
		ps.setString(3, "11");
		ps.setInt(4, 10);
		ps.setInt(5, 200);
		
		
		ps.setInt(1, 6);
		ps.setString(2, "ravidra");
		ps.setString(3, "11");
		ps.setInt(4, 8);
		ps.setInt(5, 154);
		
		ps.execute();
		System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionUtill.close(ps, connection);
		}
		
		
		
		
		
		
	}

}
