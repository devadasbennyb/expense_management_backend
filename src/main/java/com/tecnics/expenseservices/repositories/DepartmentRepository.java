package com.tecnics.expenseservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnics.expenseservices.models.DepartmentModel;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel , Long>{
	
	List<DepartmentModel> findAll();
	
	DepartmentModel findByDepartmentId(Long departmentId);
	
	DepartmentModel findByDepartmentName(String DepartmentName);
	
	@Query(value ="select * from department_table",nativeQuery = true)
	List<DepartmentModel> fetchDepartment();
	
}
