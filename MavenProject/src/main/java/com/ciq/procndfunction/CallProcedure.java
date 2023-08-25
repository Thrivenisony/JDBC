package com.ciq.procndfunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.ciq.jdbcutil.ConnectionUtill;

public class CallProcedure {
	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement callable = null;
		connection = ConnectionUtill.getConnection();
		try {
			callable = connection.prepareCall("call sum1andsub1(?,?,?,?)");
			callable.setInt(1, 10);
			callable.setInt(2, 20);
			callable.registerOutParameter(3, Types.INTEGER);
			callable.registerOutParameter(4, Types.INTEGER);
			callable.execute();
			
			System.out.println("sum:"+callable.getInt(3));
			System.out.println("sub:"+callable.getInt(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
