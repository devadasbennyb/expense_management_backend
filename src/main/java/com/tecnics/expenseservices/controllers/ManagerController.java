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

import com.tecnics.expenseservices.dtos.ManagerDto;
import com.tecnics.expenseservices.services.ManagerServices;
import com.tecnics.expenseservices.utils.ResponseMessage;

@RestController
public class ManagerController {

	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	public ManagerServices managerservices;

	@GetMapping("/fetch/managers")
	public ResponseEntity<ResponseMessage> getALlManagers() {
		List<ManagerDto> response = null;
		try {
			response = managerservices.getManagerDetails();
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

	@GetMapping("/fetch/managerById/{managerId}")
	public ResponseEntity<ResponseMessage> getManagerById(@PathVariable(value = "managerId") Long managerId) {
		ManagerDto response = null;
		try {
			response = managerservices.getManagerById(managerId);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

	@GetMapping("/fetch/manager/{managerName}")
	public ResponseEntity<ResponseMessage> getManagerByName(@PathVariable(value = "managerName") String managerName) {
		ManagerDto response = null;
		try {
			response = managerservices.getManagerByName(managerName);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PostMapping("/save/manager")
	public ResponseEntity<ResponseMessage> createManager(@RequestBody ManagerDto managerdto) {
		ManagerDto response = null;
		try {
			response = managerservices.createManager(managerdto);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/manager")
	public ResponseEntity<ResponseMessage> updateManager(@RequestBody ManagerDto managermodel) {
		ManagerDto response = null;
		try {
			response = managerservices.updateManager(managermodel);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@DeleteMapping("/delete/manager/{managerId}")
	public ResponseEntity<ResponseMessage>  deleteManagerDto(@PathVariable(value = "managerId") Long managerId) {
		try{
			managerservices.deleteManager(managerId);
		}catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			managerId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			managerId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg, managerId);
		}
	
}
