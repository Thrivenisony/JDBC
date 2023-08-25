package com.createiq.procandfun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.createiq.util.ConnectionUtil;

public class CallFunction {
	public static void main(String[] args) {

		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			callableStatement = connection.prepareCall("{ ? = call add01(?,?)}");
			callableStatement.setInt(2, 10);
			callableStatement.setInt(3, 10);
			callableStatement.registerOutParameter(1, Types.INTEGER);

			callableStatement.execute();

			System.out.println("Sum : " + callableStatement.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
