package com.ciq.jdbcchangeconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ciq.jdbcutil.ConnectionUtill;

public class Resultset {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtill.getConnection();
			ps = connection.prepareStatement("Select * from person");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String fname = rs.getString("fname");
				Double salary = rs.getDouble("salary");
				System.out.println(id + " " + fname + " " + salary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtill.close(rs, ps, connection);
		}

	}
}
