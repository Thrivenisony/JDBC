package com.ciq.jdbcdemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData {
	public static void main(String[] args) {
		Connection connection=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher", "root", "9182794292");
			st=connection.createStatement();
			ResultSet rs=st.executeQuery("select * from networkwifi");
			while(rs.next()) {
				int id=rs.getInt("id");
				String networks=rs.getString("networks");
				double sms_rates=rs.getDouble("sms_rates");
				double data_rates=rs.getDouble("data_rates");
				double call_rates=rs.getDouble("call_rates");
				Date reg_date=rs.getDate("reg_date");
				 System.out.println(networks+" "+sms_rates+" "+data_rates+" "+call_rates+" "+ reg_date);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
