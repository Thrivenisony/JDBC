package com.ciq.jdbcutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Thriveni
 * @see this class for so an so
 */
public class ConnectionUtill {
	private static Properties properties = null;
	static {
		properties = new Properties();
		try {
			properties.load(ConnectionUtill.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			Class.forName(properties.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("uname"),
					properties.getProperty("pw"));
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return connection;
	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement, Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
			statement.close();
			close(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(ResultSet resultset, Statement statement, Connection connection) {
		try {
			if (resultset != null) {
				resultset.close();
			}
			resultset.close();
			close(statement, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
