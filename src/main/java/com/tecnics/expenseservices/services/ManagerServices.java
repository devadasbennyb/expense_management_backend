package com.tecnics.expenseservices.services;

import java.util.List;

import com.tecnics.expenseservices.dtos.ManagerDto;

public interface ManagerServices {
	
	public List<ManagerDto> getManagerDetails();
	
	public ManagerDto getManagerById(Long managerId);
	
	public ManagerDto getManagerByName(String managerName);
	
	public ManagerDto createManager(ManagerDto managerdto);
	
	public ManagerDto updateManager(ManagerDto manager);
	
	public void deleteManager(Long managerId);
}
