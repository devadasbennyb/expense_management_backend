package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.EmployeeDto;
import com.tecnics.expenseservices.models.EmployeeModel;
import com.tecnics.expenseservices.repositories.DepartmentRepository;
import com.tecnics.expenseservices.repositories.EmployeeRepository;
import com.tecnics.expenseservices.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository empRepo;
	public DepartmentRepository departmentRepo;

	ModelMapper modelMapper = new ModelMapper();

	// Get Method
	@Override
	public List<EmployeeDto> getEmployeeFromDb() {
		List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
		empRepo.findAll().forEach(employeeModel -> employeeDtos.add(modelMapper.map(employeeModel, EmployeeDto.class)));

		return employeeDtos;
	}

	// Get Method
	@Override
	public EmployeeDto getEmployeeById(Long empId) {
		EmployeeModel employeeModel = empRepo.findByEmpId(empId);
		if (employeeModel != null) {
			return modelMapper.map(employeeModel, EmployeeDto.class);
		} else
			return null;
	}

	// Get Method
	public EmployeeDto findByEmail(String email) {

		EmployeeModel employeeModel = empRepo.findByEmailId(email);

		if (employeeModel != null) {
			return modelMapper.map(employeeModel, EmployeeDto.class);
		} else
			return null;
	}

	// Post Method
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {

		return modelMapper.map(empRepo.save(modelMapper.map(employeeDto, EmployeeModel.class)), EmployeeDto.class);
	}

	// Put Method
	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		EmployeeModel employeeModel = empRepo.findByEmpId(employeeDto.getEmpId());
		if (employeeModel != null) {
			if (employeeDto.getAccountNumber() != null) {
				employeeModel.setAccountNumber(employeeDto.getAccountNumber());
			}
			if (employeeDto.getAddress() != null) {
				employeeModel.setAddress(employeeDto.getAddress());
			}
			if (employeeDto.getCreditCard() != null) {
				employeeModel.setCreditCard(employeeDto.getCreditCard());
			}
			if (employeeDto.getEmailId() != null) {
				employeeModel.setEmailId(employeeDto.getEmailId());
			}
			if (employeeDto.getFirstName() != null) {
				employeeModel.setFirstName(employeeDto.getFirstName());
			}
			if (employeeDto.getLastName() != null) {
				employeeModel.setLastName(employeeDto.getLastName());
			}
			if (employeeDto.getMobile() != null) {
				employeeModel.setMobile(employeeDto.getMobile());
			}
			if (employeeDto.getState() != null) {
				employeeModel.setState(employeeDto.getState());
			}
			if (employeeDto.getZip() != null) {
				employeeModel.setZip(employeeDto.getZip());
			}

			employeeModel.setUpdated(new Timestamp(0));
			empRepo.save(employeeModel);
			return modelMapper.map(employeeModel, EmployeeDto.class);
		} else {

		}
		return null;

	}

	// Delete Method
	@Override
	public void deleteEmployee(Long empId) {
		empRepo.deleteById(empId);

	}

}
