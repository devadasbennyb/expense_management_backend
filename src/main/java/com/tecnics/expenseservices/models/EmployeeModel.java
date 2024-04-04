package com.tecnics.expenseservices.models;

import java.sql.Timestamp;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "employee")
public class EmployeeModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long employeeId;

  private String employeeName;

  @Column(nullable = false, unique = true)
  private String emailId;

  @ManyToOne
  @JoinColumn(name = "department_id")
  private DepartmentModel department;

  @CreationTimestamp
  private Timestamp created;

  @UpdateTimestamp
  private Timestamp updated;

  public EmployeeModel() {}

  public EmployeeModel(
    Long employeeId,
    String employeeName,
    String emailId,
    DepartmentModel department
  ) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.emailId = emailId;
    this.department = department;
  }

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
