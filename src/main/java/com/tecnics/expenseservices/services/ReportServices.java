package com.tecnics.expenseservices.services;

import java.util.List;

import com.tecnics.expenseservices.dtos.ReportDto;

public interface ReportServices {
	
	public List<ReportDto> getReportDetails();
	
	public ReportDto getReportById(Long ReportId);
	
	public ReportDto createReport(ReportDto report);
	
	public void deleteReport(Long reportId);
	
	public ReportDto getReportByName(String reportName);
	
	public ReportDto updateReport(ReportDto report);
	
	

}
