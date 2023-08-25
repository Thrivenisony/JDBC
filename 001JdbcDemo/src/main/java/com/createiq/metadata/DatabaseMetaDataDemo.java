package com.createiq.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.createiq.util.ConnectionUtil;

public class DatabaseMetaDataDemo {
	
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
        try {
        	connection = ConnectionUtil.getConnection();
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println("DriverName "+databaseMetaData.getDriverName());
			System.out.println("Product Name "+databaseMetaData.getDatabaseProductName());
			System.out.println("Major Version "+databaseMetaData.getDatabaseMajorVersion());
			System.out.println("Minor Version "+databaseMetaData.getDatabaseMinorVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(connection);
		}
	}

}
