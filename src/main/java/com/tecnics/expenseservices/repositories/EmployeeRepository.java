package com.tecnics.expenseservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnics.expenseservices.models.EmployeeModel;

@Repository
public interface EmployeeRepository
  extends JpaRepository<EmployeeModel, Long> {
	
  List<EmployeeModel> findAll();

  EmployeeModel findByEmpId(Long userId);

  EmployeeModel findByFirstName(String username);

  EmployeeModel findByEmailId(String email);

  @Query(value = "select * from employee_table", nativeQuery = true)
  List<EmployeeModel> fectchemployees();
}
