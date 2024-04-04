package com.tecnics.expenseservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnics.expenseservices.models.ManagerModel;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerModel , Long>{
	
	ManagerModel findByManagerName(String MmanagerName);
	
	List<ManagerModel> findAll();
	
	ManagerModel findByManagerId(Long managerId);
	
	@Query(value ="select * from manager",nativeQuery = true)
	List<ManagerModel> fetchManager();
	
	
	

}
