package com.tecnics.expenseservices.models;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class DepartmentModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long departmentId;

  @Column(nullable = false, unique = true)
  private String departmentName;

  public DepartmentModel() {}

  public DepartmentModel(Long departmentId, String departmentName) {
    this.departmentId = departmentId;
    this.departmentName = departmentName;
  }

  /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

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
}
