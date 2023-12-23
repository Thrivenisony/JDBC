package com.ciq.service;

import com.ciq.dto.ResponseDto;
import com.ciq.entity.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    
    ResponseDto getEmployee(Long id);

  
}