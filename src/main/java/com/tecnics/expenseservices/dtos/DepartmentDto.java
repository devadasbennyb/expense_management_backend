package com.tecnics.expenseservices.dtos;

import java.sql.Timestamp;

public class DepartmentDto {
	
	private Long departmentId;
	
	private String departmentName;

	private String DepartmentDescription;
	
	private Timestamp created;

	private Timestamp updated;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return DepartmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		DepartmentDescription = departmentDescription;
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

   

}
