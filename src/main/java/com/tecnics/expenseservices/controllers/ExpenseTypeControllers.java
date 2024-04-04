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

import com.tecnics.expenseservices.dtos.ExpenseTypeDto;
import com.tecnics.expenseservices.services.ExpenseTypeServices;
import com.tecnics.expenseservices.utils.ResponseMessage;

@RestController
public class ExpenseTypeControllers {

	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	public ExpenseTypeServices expenseTypeServices;

	@GetMapping("/fetch/expenseType")
	public ResponseEntity<ResponseMessage> getExpenseTypes() {
		List<ExpenseTypeDto> response = null;
		try {
			response = expenseTypeServices.getExpenseAllTypes();
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

	@GetMapping("/fetch/expenseType/{expenseTypeId}")
	public ResponseEntity<ResponseMessage> getExpenseTypeById(@PathVariable(value = "expenseTypeId") Long ExpenseTypeId) {
		ExpenseTypeDto response = null;
		try {
			response = expenseTypeServices.getExpenseTypeById(ExpenseTypeId);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);

	}

	@GetMapping("/fetch/expenseTypeByName/{expenseType}")
	public  ResponseEntity<ResponseMessage> getExpenseTypeByName(@PathVariable(value ="expenseType") String expenseType) {
		ExpenseTypeDto response = null;
		try {
			response = expenseTypeServices.getByExpenseType(expenseType);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}
	
	

	@PostMapping("/save/expenseType")
	public ResponseEntity<ResponseMessage> createExpenseType(@RequestBody ExpenseTypeDto expenseTypeDto) {
		ExpenseTypeDto response = null;
		try {
			response = expenseTypeServices.createExpenseType(expenseTypeDto);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/expenseType")
	public ResponseEntity<ResponseMessage> UpdateExpenseType(@RequestBody ExpenseTypeDto expenseTypeDto) {
		ExpenseTypeDto response = null;
		try {
			response = expenseTypeServices.updateExpenseType(expenseTypeDto);
			
		}catch(DataIntegrityViolationException e ) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		}catch(Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage,exceptionMsg,response);
	}

	@DeleteMapping("/delete/expenseType/{expenseTypeId}")
	public ResponseEntity<ResponseMessage>  DeleteExpenseType(@PathVariable(value = "expenseTypeId") Long expenseTypeId) {
		try { expenseTypeServices.deleteExpenseType(expenseTypeId);
		}catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			expenseTypeId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			expenseTypeId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg, expenseTypeId);
		}
	}


