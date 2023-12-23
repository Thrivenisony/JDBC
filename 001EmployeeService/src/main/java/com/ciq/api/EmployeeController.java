package com.ciq.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.dto.ResponseDto;
import com.ciq.entity.Employee;
import com.ciq.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	   @PostMapping
	    public ResponseEntity<Employee> saveUser(@RequestBody Employee employee){
	        Employee savedEmployee = employeeService.saveEmployee(employee);
	        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	    }
	   
	   @GetMapping("{id}")
	   public ResponseEntity<ResponseDto> getEmployee(@PathVariable("id") Long id){
	        ResponseDto responseDto = employeeService.getEmployee(id);
	        return ResponseEntity.ok(responseDto);
	    }
	   

}
