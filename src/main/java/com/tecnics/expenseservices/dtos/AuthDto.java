package com.tecnics.expenseservices.dtos;

/**
 * @author Mohammad Faizullah Ansari
 * @email faizullah_md@tecnics.com
 * @description
 */

public class AuthDto {

  private String username;
  private String password;

  private UserProfileDto userProfile;

  public AuthDto() {}

  public AuthDto(String username, String password, UserProfileDto userProfile) {
    this.username = username;
    this.password = password;
    this.userProfile = userProfile;
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

  public UserProfileDto getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfileDto userProfile) {
    this.userProfile = userProfile;
  }
}
