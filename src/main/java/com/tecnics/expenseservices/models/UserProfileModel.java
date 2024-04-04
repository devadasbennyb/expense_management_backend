package com.tecnics.expenseservices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tecnics.expenseservices.utils.UserRoleEnum;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Mohammad Faizullah Ansari
 * @email faizullah_md@tecnics.com
 * @description
 */

@Entity
@Table(name = "user_profile")
public class UserProfileModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;

  private String lastName;

  private String imageUrl;

  @Column(unique = true)
  @NotBlank
  private String email;

  @Enumerated(EnumType.STRING)
  private UserRoleEnum role;

  @CreationTimestamp
  private Timestamp created;

  @UpdateTimestamp
  private Timestamp updated;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  @JsonIgnore
  private AuthModel userAuth;

  public UserProfileModel() {}

  public UserProfileModel(
    String firstName,
    String lastName,
    String imageUrl,
    @NotBlank String email,
    UserRoleEnum role
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.imageUrl = imageUrl;
    this.email = email;
    this.role = role;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserRoleEnum getRole() {
    return role;
  }

  public void setRole(UserRoleEnum role) {
    this.role = role;
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

  public AuthModel getUserAuth() {
    return userAuth;
  }

  public void setUserAuth(AuthModel userAuth) {
    this.userAuth = userAuth;
  }
}
