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

import com.tecnics.expenseservices.dtos.ExpenseDto;
import com.tecnics.expenseservices.services.ExpenseService;
import com.tecnics.expenseservices.utils.ResponseMessage;

@RestController
public class ExpenseController {

	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	public ExpenseService expenseService;

	@GetMapping("/fetch/expenses")
	public ResponseEntity<ResponseMessage> getAllExpenses() {
		List<ExpenseDto> response = null;
		try {
			response = expenseService.getAllExpenses();
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

	@GetMapping("/fetch/expenseById/{expId}")
	public ResponseEntity<ResponseMessage> getExpenseById(@PathVariable(value = "expId") Long expId) {
		ExpenseDto response = null;
		try {
			response = expenseService.getExpenseById(expId);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);

	}

	@GetMapping("/fetch/expense/{merchant}")
	public ResponseEntity<ResponseMessage> getExpensesByName(@PathVariable(value = "merchant") String merchant) {

		ExpenseDto response = null;
		try {
			response = expenseService.getExpensesByName(merchant);
					if(response == null) {
						errorMessage = NO_RECORD_FOUND;
					}
		}catch(Exception e ) {
			errorMessage = JSON_PROCESSING_FAILED;
			e.getMessage();
		}
		return processResponse(errorMessage,exceptionMsg,response);
	}

	@PostMapping("/save/expense")
	public ResponseEntity<ResponseMessage> addExpense(@RequestBody ExpenseDto expenseDto) {
		ExpenseDto response = null;
		try {
			response = expenseService.addExpense(expenseDto);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/expense")
	public ResponseEntity<ResponseMessage> updateExpense(@RequestBody ExpenseDto expenseDto) {
		ExpenseDto response = null;
		try {
			response = expenseService.updateExpense(expenseDto);
			
		}catch(DataIntegrityViolationException e){
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		}catch(Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage,exceptionMsg,response);
	}

	@DeleteMapping("delete/expense/{expId}")
	public ResponseEntity<ResponseMessage> deleteExpense(@PathVariable(value = "expId") Long expId) {
		try{expenseService.deleteExpense(expId);
		}catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			expId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			expId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg, expId);

		}
	}


