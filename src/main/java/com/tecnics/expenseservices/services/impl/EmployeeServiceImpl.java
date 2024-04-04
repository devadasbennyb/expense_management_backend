package com.tecnics.expenseservices.services.impl;

import com.tecnics.expenseservices.dtos.EmployeeDTO;
import com.tecnics.expenseservices.models.EmployeeModel;
import com.tecnics.expenseservices.repositories.EmployeeRepository;
import com.tecnics.expenseservices.services.EmployeeService;
import java.lang.reflect.Type;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  EmployeeRepository employeeRepo;

  ModelMapper modelMapper = new ModelMapper();

  @Override
  public EmployeeDTO save(EmployeeDTO employee) {
    return modelMapper.map(
      employeeRepo.save(modelMapper.map(employee, EmployeeModel.class)),
      EmployeeDTO.class
    );
  }

  @Override
  public EmployeeDTO fetchById(Long employeeId) {
    return modelMapper.map(
      employeeRepo.findByEmployeeId(employeeId),
      EmployeeDTO.class
    );
  }

  @Override
  public List<EmployeeDTO> fetchEmployees() {
    Type listType = new TypeToken<List<EmployeeDTO>>() {}.getType();
    return modelMapper.map(employeeRepo.findAll(), listType);
  }
}
