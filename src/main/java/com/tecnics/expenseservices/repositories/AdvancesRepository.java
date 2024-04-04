package com.tecnics.expenseservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnics.expenseservices.models.AdvancesModel;

@Repository
public interface AdvancesRepository extends JpaRepository<AdvancesModel ,Long>{
	
	public List<AdvancesModel> findAll();
	
	public AdvancesModel findByAdvanceName(String AdvanceName);
	
	public AdvancesModel findByAdvanceId(Long AdvanceId);	
	
	@Query(value ="select * from advances_Table",nativeQuery = true)
	List<AdvancesModel> fetchAdvances();	


}
