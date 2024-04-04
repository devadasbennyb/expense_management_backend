package com.tecnics.expenseservices.dtos;

import com.tecnics.expenseservices.models.DepartmentModel;

public class EmployeeDTO {

  private Long employeeId;

  private String employeeName;

  private String emailId;

  private DepartmentModel department;

  /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public DepartmentModel getDepartment() {
    return department;
  }

  public void setDepartment(DepartmentModel department) {
    this.department = department;
  }
}
