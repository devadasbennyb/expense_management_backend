package com.tecnics.expenseservices.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.tecnics.expenseservices.utils.Status;

@Entity
@Table(name = "report_table")
public class ReportModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private EmployeeModel employeeModel;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false, unique = true)
	private String reportName;

	@Column(nullable = false)
	private String duration;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;

	private Long Total;

	private String description;

	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;

	public ReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportModel(Long reportId, EmployeeModel employeeModel, Date date, String reportName, String duration,
			Status status, String description, Long Total, Timestamp created, Timestamp updated) {
		super();
		this.reportId = reportId;
		this.employeeModel = employeeModel;
		this.date = date;
		this.reportName = reportName;
		this.duration = duration;
		this.Total = Total;
		this.status = status;
		this.description = description;
		this.created = created;
		this.updated = updated;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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
		return Total;
	}

	public void setTotal(Long total) {
		Total = total;
	}

}
