package com.createiq.procandfun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.createiq.util.ConnectionUtil;

public class CallProc {
	
	public static void main(String[] args) {
		
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			callableStatement = connection.prepareCall("call sumAndSub(?,?,?,?)");
			callableStatement.setInt(1, 10);
			callableStatement.setInt(2, 10);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.registerOutParameter(4, Types.INTEGER);
			
			callableStatement.execute();
			
			System.out.println("Sum : "+callableStatement.getInt(3));
			System.out.println("Sub : "+callableStatement.getInt(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
