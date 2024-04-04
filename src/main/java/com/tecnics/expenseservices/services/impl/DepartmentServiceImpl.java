package com.tecnics.expenseservices.services.impl;

import com.tecnics.expenseservices.dtos.DepartmentDTO;
import com.tecnics.expenseservices.models.DepartmentModel;
import com.tecnics.expenseservices.repositories.DepartmentRepository;
import com.tecnics.expenseservices.services.DepartmentService;
import java.lang.reflect.Type;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  DepartmentRepository departmentRepo;

  ModelMapper modelMapper = new ModelMapper();

  @Override
  public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
    return modelMapper.map(
      departmentRepo.save(
        modelMapper.map(departmentDTO, DepartmentModel.class)
      ),
      DepartmentDTO.class
    );
  }

  @Override
  public List<DepartmentDTO> fetchDepartments() {
    Type listType = new TypeToken<List<DepartmentDTO>>() {}.getType();
    return modelMapper.map(departmentRepo.findAll(), listType);
  }

  @Override
  public DepartmentDTO fetchDepartmentById(Long departmentId) {
    return modelMapper.map(
      departmentRepo.findByDepartmentId(departmentId),
      DepartmentDTO.class
    );
  }
}
