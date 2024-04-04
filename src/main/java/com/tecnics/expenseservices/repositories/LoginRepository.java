package com.tecnics.expenseservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnics.expenseservices.models.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long> {
	
	List<LoginModel> findAll();
	
	LoginModel findByEmployeeId(Long EmpId);
	
	LoginModel findByLastLogin(String Login);
	
	LoginModel findByUsername(String Username);
	
	LoginModel findByLoginStatus(String loginstatus);
	
	@Query(value = "select * from login_table", nativeQuery = true)
	List<LoginModel> fetchLogin();
	
}
