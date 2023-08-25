package com.createiq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.createiq.util.ConnectionUtil;
import com.mysql.cj.conf.ConnectionUrl;

public class ConnectionTest {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		connection = ConnectionUtil.getConnection();
        System.out.println(connection);
        ConnectionUtil.close(connection);
	}

}
