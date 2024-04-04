package com.tecnics.expenseservices.services;

import com.tecnics.expenseservices.dtos.DepartmentDTO;
import java.util.List;

public interface DepartmentService {
  public DepartmentDTO saveDepartment(DepartmentDTO departmentModel);

  public DepartmentDTO fetchDepartmentById(Long departmentId);

  public List<DepartmentDTO> fetchDepartments();
}
