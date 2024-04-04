package com.tecnics.expenseservices.services;

import java.util.List;

import com.tecnics.expenseservices.dtos.EmployeeDto;

public interface EmployeeService {

	public List<EmployeeDto> getEmployeeFromDb();

	public EmployeeDto getEmployeeById(Long empId);

	public EmployeeDto findByEmail(String email);
	
	public EmployeeDto updateEmployee(EmployeeDto employeeDto);

	public EmployeeDto addEmployee(EmployeeDto employeeDto);
	
	public void deleteEmployee(Long empId);

}
