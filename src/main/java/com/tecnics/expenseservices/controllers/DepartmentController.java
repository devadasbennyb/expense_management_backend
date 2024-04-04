package com.tecnics.expenseservices.controllers;

import static com.tecnics.expenseservices.utils.Constants.JSON_PROCESSING_FAILED;
import static com.tecnics.expenseservices.utils.Constants.NO_RECORD_FOUND;
import static com.tecnics.expenseservices.utils.Constants.RECORD_IS_ALREADY_EXIST;
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

import com.tecnics.expenseservices.dtos.DepartmentDto;
import com.tecnics.expenseservices.services.DepartmentServices;
import com.tecnics.expenseservices.utils.ResponseMessage;

@RestController
public class DepartmentController {

	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	public DepartmentServices departmentServices;

	@GetMapping("/fetch/departments")
	public ResponseEntity<ResponseMessage> getDepartmentDetails() {
		List<DepartmentDto> response = null;
		try {
			response = departmentServices.getDepartmentDetails();
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

	@GetMapping("/fetch/department/{departmentId}")
	public ResponseEntity<ResponseMessage> getByDepartmentId(@PathVariable(value = "departmentId") Long departmentId) {
		DepartmentDto response = null;
		try {
			response = departmentServices.getDepartmentById(departmentId);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}
	
	@GetMapping("/fetch/departmentByName/{departmentName}")
	public ResponseEntity<ResponseMessage> getDepartmentByName(@PathVariable(value = "departmentName") String departmentName){
		DepartmentDto response = null;
		try
		{
			response = departmentServices.getDepartmentByName(departmentName);
			if(response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		}	catch(Exception e) {
				errorMessage = JSON_PROCESSING_FAILED;
				exceptionMsg = e.getMessage();
			}
		return processResponse(errorMessage,exceptionMsg,response);
		
		}
		
	

	@PostMapping("/save/department")
	public ResponseEntity<ResponseMessage> createDepartment(@RequestBody DepartmentDto departmentModel) {
		DepartmentDto response = null;
		try {
			response = departmentServices.createDepartment(departmentModel);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/department")
	public ResponseEntity<ResponseMessage> updateDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto response = null;
		try {
			response = departmentServices.updateDepartment(departmentDto);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@DeleteMapping("/delete/department/{departmentId}")
	public ResponseEntity<ResponseMessage> DeleteDepartment(@PathVariable(value = "departmentId") Long departmentId) {
		try {
			departmentServices.deleteDepartment(departmentId);
		} catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			departmentId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			departmentId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg, departmentId);
	}

}
