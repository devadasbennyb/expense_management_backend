package com.tecnics.expenseservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnics.expenseservices.models.ReportModel;

@Repository
public interface ReportRepository extends JpaRepository<ReportModel, Long> {
	
	List<ReportModel> findAll();
	
	ReportModel findByReportId(Long ReportId);
	
	ReportModel findByReportName(String Reportname);
	
	@Query(value = "select * from reports", nativeQuery = true)
	List<ReportModel> fetchReport();
	

}
