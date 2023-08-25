package com.ciq.dao;

import java.util.List;

import com.ciq.model.Staff;

public interface StaffDao {
	
	 void save(Staff staff);
	 void delete(int id);
	 void addcon();
	 void addconsalary();
	 void update(Staff staff);
	 List<Staff>getall();
	

}
