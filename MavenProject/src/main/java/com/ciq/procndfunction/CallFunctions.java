package com.ciq.procndfunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.ciq.jdbcutil.ConnectionUtill;

public class CallFunctions {
	public static void main(String[] args) {
		Connection connection=null;
		CallableStatement callable=null;
		
		try {
			connection=ConnectionUtill.getConnection();
			callable=connection.prepareCall("{? =call add05(?,?)}");
			callable.setInt(2, 10);
			callable.setInt(3, 20);
			callable.registerOutParameter(1,Types.INTEGER);
			callable.execute();
			System.out.println("sum:"+callable.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
