package com.ciq.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ciq.dto.DepartmentDto;
import com.ciq.dto.EmployeeDto;
import com.ciq.dto.ResponseDto;
import com.ciq.entity.Employee;
import com.ciq.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	private RestTemplate restTemplate;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public ResponseDto getEmployee(Long id) {
		
		

		Employee employee = employeeRepository.findById(id).get();

		EmployeeDto employeeDto = mapToEmployee(employee);
		
		ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("lb://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentId(),
                DepartmentDto.class);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setEmployeeDto(employeeDto);
        responseDto.setDepartmentDto(responseEntity.getBody());
		return responseDto;
	}

	private EmployeeDto mapToEmployee(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setEmail(employee.getEmail());
		return employeeDto;

	}

}