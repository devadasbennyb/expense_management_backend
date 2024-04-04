package com.tecnics.expenseservices.controllers;

import static com.tecnics.expenseservices.utils.Constants.JSON_PROCESSING_FAILED;
import static com.tecnics.expenseservices.utils.Constants.NO_RECORD_FOUND;
import static com.tecnics.expenseservices.utils.Constants.RECORD_IS_ALREADY_EXIST;
import static com.tecnics.expenseservices.utils.ResponseUtility.processResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tecnics.expenseservices.dtos.LoginDto;
import com.tecnics.expenseservices.services.LoginServices;
import com.tecnics.expenseservices.utils.ResponseMessage;

@RestController
public class LoginController {

	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	public LoginServices loginservices;

	@GetMapping("/fetch/login")
	public ResponseEntity<ResponseMessage> getLoginDetails() {
		List<LoginDto> response = null;
		try {
			response = loginservices.getLoginDetails();
			if (response == null|| response.isEmpty()) {
				errorMessage = NO_RECORD_FOUND;
				response = null;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

	@GetMapping("/fetch/loginStatus/{status}")
	public ResponseEntity<ResponseMessage> getLoginStatus(@PathVariable(value ="status") String status) {
		LoginDto response = null;
		try {
			response = loginservices.getLoginStatus(status);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);

	}

	@GetMapping("fetch/username/{username}")
	public ResponseEntity<ResponseMessage> getUsername(@PathVariable(value ="username") String username) {
		LoginDto response = null;
		try {
			response = loginservices.getUsername(username);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	
	}

	@PostMapping("/save/login")
	public ResponseEntity<ResponseMessage> createLogin(@RequestBody LoginDto loginDto) {
		LoginDto response = null;
		try {
			response = loginservices.createLogin(loginDto);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/login")
	public ResponseEntity<ResponseMessage> updateLogin(@RequestBody LoginDto login) {
		LoginDto response = null;
		try {
			response = loginservices.updateLogin(login);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

}
