package com.tecnics.expenseservices.dtos;

import java.sql.Date;
import java.sql.Timestamp;

import com.tecnics.expenseservices.models.EmployeeModel;
import com.tecnics.expenseservices.utils.Status;

public class ReportDto {

	private String reportName;

	private Long reportId;

	private Date date;

	private EmployeeModel employeeModel;

	private Status status;

	private String description;

	private String duration;
	
	private Long total;

	private Timestamp created;

	private Timestamp updated;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	

}
