package com.tecnics.expenseservices.repositories;

import com.tecnics.expenseservices.models.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository
  extends JpaRepository<DepartmentModel, Long> {
  DepartmentModel findByDepartmentId(Long departmentId);
}
