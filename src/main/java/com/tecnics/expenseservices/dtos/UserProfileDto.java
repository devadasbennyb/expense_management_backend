package com.tecnics.expenseservices.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tecnics.expenseservices.utils.UserRoleEnum;

/**
 * @author Mohammad Faizullah Ansari
 * @email faizullah_md@tecnics.com
 * @description
 */
public class UserProfileDto {

  private String firstName;

  private String lastName;

  private String imageUrl;

  private String email;

  private UserRoleEnum role;

  @JsonIgnore
  private AuthDto authDto;

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

  public AuthDto getAuthDto() {
    return authDto;
  }

  public void setAuthDto(AuthDto authDto) {
    this.authDto = authDto;
  }
}
