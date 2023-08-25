package com.ciq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ciq.jdbcutill.ConnectionUtill;
import com.ciq.model.Staff;
import com.ciq.queries.StaffQueries;

public class StaffDaoImp implements StaffDao {
	Connection connection=null;
	PreparedStatement ps=null;
	ResultSet resultset=null;
	
	

	@Override
	public void save(Staff staff) {
		connection=ConnectionUtill.getConnection();
		try {
			ps=connection.prepareStatement(StaffQueries.staff_insert);
			ps.setInt(1,staff.getId());
			ps.setString(2, staff.getName());
			ps.setDouble(3, staff.getSalary());
			ps.setString(4, staff.getAddress());
			int result=ps.executeUpdate();
			System.out.println(result+"inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionUtill.close(connection);
			if(ps!=null) {
				try {
				
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
		
		
		
		}



	@Override
	public void delete(int id) {
		connection=ConnectionUtill.getConnection();
		try {
			ps=connection.prepareStatement(StaffQueries.staff_delete);
			ps.setInt(1, id);
			int result=ps.executeUpdate();
			System.out.println(result+"delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionUtill.close(connection);
			if(ps!=null) {
				
			
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
	}



	@Override
	public void addcon() {
		connection=ConnectionUtill.getConnection();
		try {
			ps=connection.prepareStatement(StaffQueries.staff_unique);
			
			int result=ps.executeUpdate();
			System.out.println(result+"add unique");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionUtill.close(connection);
			if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
		
	}



	@Override
	public void addconsalary() {
		
		connection=ConnectionUtill.getConnection();
		try {
			ps=connection.prepareStatement(StaffQueries.staff_unique_salary);
			
			int result=ps.executeUpdate();
			System.out.println(result+"add consalary");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionUtill.close(connection);
			if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		}


		}



	@Override
	public void update(Staff staff) {
		connection=ConnectionUtill.getConnection();
		try {
			ps=connection.prepareStatement(StaffQueries.staff_update);
			ps.setInt(4, staff.getId());
			ps.setString(1, staff.getName());
			ps.setDouble(2, staff.getSalary());
			ps.setString(3, staff.getAddress());
			int result=ps.executeUpdate();
			System.out.println(result+"update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionUtill.close(connection);
			if(ps!=null) {
				
			
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}	
	}



	@Override
	public List<Staff> getall() {
		
		try {
			connection=ConnectionUtill.getConnection();
			ps=connection.prepareStatement(StaffQueries.staff_getall);
			resultset=ps.executeQuery();
			while (resultset.next()) {
				Staff st=new Staff();
				st.setId(resultset.getInt(1));
				st.setName(resultset.getString(2));
				st.setSalary(resultset.getDouble(3));
				st.setAddress(resultset.getString(4));
				System.out.println(st);
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}	
	
	

}
