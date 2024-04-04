package com.tecnics.expenseservices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "user_auth")
public class AuthModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  @NotBlank
  private String username;

  @JsonIgnore
  @NotBlank
  private String password;

  @CreationTimestamp
  private Timestamp created;

  @UpdateTimestamp
  private Timestamp updated;

  @OneToOne(
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    mappedBy = "userAuth"
  )
  private UserProfileModel userProfile;

  public AuthModel() {}

  public AuthModel(@NotBlank String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public UserProfileModel getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfileModel userProfile) {
    this.userProfile = userProfile;
  }
}
