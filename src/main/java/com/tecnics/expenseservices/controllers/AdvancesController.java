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

import com.tecnics.expenseservices.dtos.AdvancesDto;
import com.tecnics.expenseservices.services.AdvancesServices;
import com.tecnics.expenseservices.utils.ResponseMessage;

@RestController
public class AdvancesController {

	@Autowired
	AdvancesServices advancesServices;

	String errorMessage = null;
	String exceptionMsg = null;

	@GetMapping("/fetch/advances")
	public ResponseEntity<ResponseMessage> getAllAdvances() {

		List<AdvancesDto> response = null;
		try {
			response = advancesServices.getAllAdvances();
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

	@GetMapping("/fetch/advance/{advanceId}")
	public ResponseEntity<ResponseMessage> getAdvancesById(@PathVariable(value = "advanceId") Long advanceId) {

		AdvancesDto response = null;
		try {
			response = advancesServices.getAdvancesByAdvancesId(advanceId);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

	@GetMapping("/fetch/advanceByName/{advanceName}")
	public ResponseEntity<ResponseMessage> getAdvancesByName(@PathVariable(value = "advanceName") String advanceName) {

		AdvancesDto response = null;
		try {
			response = advancesServices.getAdvancesByAdvanceName(advanceName);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}

		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PostMapping("/save/advance")
	public ResponseEntity<ResponseMessage> createAdvances(@RequestBody AdvancesDto advanceDto) {

		AdvancesDto response = null;
		try {
			response = advancesServices.createAdvance(advanceDto);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;	
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/advance")
	public ResponseEntity<ResponseMessage> updateAdvances(@RequestBody AdvancesDto advanceDto) {

		AdvancesDto response = null;
		try {
			response = advancesServices.updateAdvances(advanceDto);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@DeleteMapping("/delete/advance/{advanceId}")
	public ResponseEntity<ResponseMessage> DeleteAdvances(@PathVariable(value = "advanceId") Long advanceId) {

		try {
			advancesServices.deleteAdvances(advanceId);
			
		} catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			advanceId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			advanceId = null;
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();

		}
		return processResponse(errorMessage, exceptionMsg, "Deleted Succesfully");

	}
}
