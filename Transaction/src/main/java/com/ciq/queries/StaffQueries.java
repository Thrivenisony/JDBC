package com.ciq.queries;

public interface StaffQueries {
	 
	 static String staff_insert = "INSERT INTO STAFF VALUES(?,?,?,?)";
     static String staff_delete="delete from staff where id=?";
     static String staff_unique="alter table staff add constraint unique (id)";
     static String staff_unique_salary="alter table staff alter column salary set default (25000)";
     static String staff_update="update staff set name=?,salary=?,address=? where id=?";
     static String staff_getall="select * from staff";
}
