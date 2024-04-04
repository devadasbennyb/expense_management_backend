package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.LoginDto;
import com.tecnics.expenseservices.models.LoginModel;
import com.tecnics.expenseservices.repositories.LoginRepository;
import com.tecnics.expenseservices.services.LoginServices;

@Service
public class LoginServicesImpl implements LoginServices {

	@Autowired
	private LoginRepository loginrepo;
	ModelMapper modelMapper = new ModelMapper();
	
	// Get Method
	@Override
	public List<LoginDto> getLoginDetails() {
		
		List<LoginDto> loginDto = new ArrayList<LoginDto>();
		loginrepo.findAll().forEach(loginModel ->
					loginDto.add(modelMapper.map(loginModel, LoginDto.class)));

		return loginDto;
	}

	// Get Method
	@Override
	public LoginDto getLastLogin(String lastLogin) {

		return modelMapper.map(
				loginrepo.findByLastLogin(lastLogin), LoginDto.class);

	}

	// Get Method
	@Override
	public LoginDto getLoginStatus(String status) {
		return modelMapper.map(
				loginrepo.findByLoginStatus(status), LoginDto.class);
	}

	// Get Method
	@Override
	public LoginDto getUsername(String username) {
		return modelMapper.map(
				loginrepo.findByUsername(username), LoginDto.class);

	}

	// Post Method
	@Override
	public LoginDto createLogin(LoginDto login) {

		return modelMapper.map(
				loginrepo.save(modelMapper.map(login, LoginModel.class)), LoginDto.class);
	}

	// Put Method
	@Override
	public LoginDto updateLogin(LoginDto login) {
		LoginModel loginmodel = loginrepo.findByEmployeeId(login.getEmployeeId());
		if(loginmodel != null) {
			if(login.getPassword() != null) {
				loginmodel.setPassword(login.getPassword());
			}
			if(login.getUsername() != null) {
				loginmodel.setUsername(login.getUsername());
			}
			loginmodel.setUpdated(new Timestamp(0));
			loginrepo.save(loginmodel);
			return modelMapper.map(loginmodel, LoginDto.class);
		}else return null;
	}

}
