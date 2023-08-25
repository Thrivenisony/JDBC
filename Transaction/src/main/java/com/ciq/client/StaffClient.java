package com.ciq.client;

import com.ciq.Service.ServiceImp;
import com.ciq.model.Staff;

public class StaffClient {
	public static void main(String[] args) {
		Staff staff=new Staff(15, "Savithri", 20000, "Ghanpur");
		ServiceImp ser=new ServiceImp();
		ser.save(staff);
		
		ser.delete(15);
		ser.addcon();
		ser.addconsalary();
		
		Staff staff2=new Staff(7, "thadurithriveni", 5000, "hyd");
		ser.update(staff2);
		ser.getall();
	}


}
