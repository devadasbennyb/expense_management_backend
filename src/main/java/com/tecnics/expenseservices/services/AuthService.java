package com.tecnics.expenseservices.services;

import com.tecnics.expenseservices.dtos.AuthDto;
import com.tecnics.expenseservices.dtos.UpdatePasswordDto;
import com.tecnics.expenseservices.dtos.UserProfileDto;
import com.tecnics.expenseservices.models.AuthModel;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Mohammad Faizullah Ansari
 * @email faizullah_md@tecnics.com
 * @description
 */

public interface AuthService extends UserDetailsService {
	
  public AuthModel saveUser(AuthDto authDto) throws Exception;

  public List<UserProfileDto> fetchAllUsers();

  public AuthModel getUserByUsername(String username);

  public String updatePassword(UpdatePasswordDto updatePasswordDto);

  public UserProfileDto updateProfile(UserProfileDto userProfileDto);
}
