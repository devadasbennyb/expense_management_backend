package com.tecnics.expenseservices.services;

import java.util.List;
import com.tecnics.expenseservices.dtos.LoginDto;

public interface LoginServices {

	public List<LoginDto> getLoginDetails();

	public LoginDto getLastLogin(String lastLogin);

	public LoginDto getLoginStatus(String loginStatus);

	public LoginDto getUsername(String Username);

	public LoginDto createLogin(LoginDto login);

	public LoginDto updateLogin(LoginDto login);

}
