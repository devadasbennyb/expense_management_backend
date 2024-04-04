package com.tecnics.expenseservices.services;

import com.tecnics.expenseservices.dtos.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
  public EmployeeDTO save(EmployeeDTO employee);

  public EmployeeDTO fetchById(Long employeeId);

  public List<EmployeeDTO> fetchEmployees();
}
