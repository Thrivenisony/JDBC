package com.ciq.Service;

import java.util.List;

import com.ciq.dao.StaffDaoImp;
import com.ciq.model.Staff;

public class ServiceImp implements StaffService  {
  StaffDaoImp sdi=new StaffDaoImp();
	
	@Override
	public void save(Staff staff) {
	sdi.save(staff);
		
	}

	@Override
	public void delete(int id) {
		sdi.delete(id);
	}

	@Override
	public void addcon() {
		sdi.addcon();
		
	}

	@Override
	public void addconsalary() {
		sdi.addconsalary();
		
	}

	@Override
	public void update(Staff staff) {
		sdi.update(staff);
		
	}

	@Override
	public List<Staff> getall() {
		sdi.getall();
		return null;
	}

	

	

}
