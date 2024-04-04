package com.tecnics.expenseservices.repositories;

import com.tecnics.expenseservices.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
  EmployeeModel findByEmployeeId(Long employeeId);
}
