package com.tecnics.expenseservices.controllers;

import static com.tecnics.expenseservices.utils.Constants.*;
import static com.tecnics.expenseservices.utils.ResponseUtility.processResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tecnics.expenseservices.dtos.EmployeeDto;
import com.tecnics.expenseservices.services.EmployeeService;
import com.tecnics.expenseservices.utils.ResponseMessage;

@RestController
public class EmployeeController {

	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	public EmployeeService employeeService;

	@GetMapping("/fetch/employee")
	public ResponseEntity<ResponseMessage> getEmployeeDetails() {
		List<EmployeeDto> response = null;
		try {
			response = employeeService.getEmployeeFromDb();
			if (response == null || response.isEmpty()) {
				errorMessage = NO_RECORD_FOUND;
				response = null;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

	@GetMapping("/fetch/employee/{empId}")
	public ResponseEntity<ResponseMessage> getEmployeeById(@PathVariable(value = "empId") Long empId) {
		EmployeeDto response = null;
		try {
			response = employeeService.getEmployeeById(empId);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

	@GetMapping("/fetch/employeeByEmail/{email}")
	public ResponseEntity<ResponseMessage> findByEmail(@PathVariable(value = "email") String email) {
		EmployeeDto response = null;
		try {
			response = employeeService.findByEmail(email);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PostMapping("/save/employee")
	public ResponseEntity<ResponseMessage> addEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto response = null;
		try {
			response = employeeService.addEmployee(employeeDto);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/employee")
	public ResponseEntity<ResponseMessage> updateEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto response = null;
		try {
			response = employeeService.updateEmployee(employeeDto);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();

		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);

	}

	@DeleteMapping("/delete/employee/{empId}")
	public ResponseEntity<ResponseMessage> DeleteDepartment(@PathVariable (value = "empId") Long empId) {
		try{
			employeeService.deleteEmployee(empId);
		}catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			empId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			empId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg, empId);

	}
}
