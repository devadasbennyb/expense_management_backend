package com.tecnics.expenseservices.services;

import java.util.List;

import com.tecnics.expenseservices.dtos.DepartmentDto;

public interface DepartmentServices {

	public List<DepartmentDto> getDepartmentDetails();

	public DepartmentDto getDepartmentById(Long departmentId);
	
	public DepartmentDto getDepartmentByName(String departmentName); 

	public DepartmentDto createDepartment(DepartmentDto departmentDto);

	public DepartmentDto updateDepartment(DepartmentDto department);

	public void deleteDepartment(Long DeprtId);

}
