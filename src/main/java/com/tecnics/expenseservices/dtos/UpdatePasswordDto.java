package com.tecnics.expenseservices.dtos;

/**
 * @author Mohammad Faizullah Ansari
 * @email faizullah_md@tecnics.com
 * @description
 */

public class UpdatePasswordDto {

  private String oldPassword;
  private String newPassword;

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }
}
