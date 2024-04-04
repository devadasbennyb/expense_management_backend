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

import com.tecnics.expenseservices.dtos.TripDto;
import com.tecnics.expenseservices.services.TripServices;
import com.tecnics.expenseservices.utils.ResponseMessage;

@RestController
public class TripController {

	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	public TripServices tripservices;

	@GetMapping("/fetch/trips")
	public ResponseEntity<ResponseMessage> getTripDetails() {
		List<TripDto> response = null;
		try {
			response = tripservices.getTripDetails();
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

	@GetMapping("/fetch/trip/{tripId}")
	public ResponseEntity<ResponseMessage> getTripById(@PathVariable(value = "tripId") Long tripId) {
		TripDto response = null;
		try {
			response = tripservices.getTripById(tripId);
			if (response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();

		}
		return processResponse(errorMessage, exceptionMsg, response);

	}
	
	@GetMapping("/fetch/tripByName/{tripName}")
	public ResponseEntity<ResponseMessage> getTripByName(@PathVariable(value ="tripName") String tripName){
		
		TripDto response = null;
		try {
			response = tripservices.getTripByName(tripName);
			if(response == null) {
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();

		}
		return processResponse(errorMessage,exceptionMsg,response);
	}

	@PostMapping("/save/trip")
	public ResponseEntity<ResponseMessage> createTrip(@RequestBody TripDto trip) {
		TripDto response = null;
		try {
			response = tripservices.createTrip(trip);
		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();

		}
		return processResponse(errorMessage, exceptionMsg, response);
	}

	@PutMapping("/update/trip")
	public ResponseEntity<ResponseMessage> UpdateTrip(@RequestBody TripDto trip) {

	TripDto response = null;
	try {
		response = tripservices.updateTrip(trip);
			
	}catch(DataIntegrityViolationException e) {
		errorMessage = RECORD_IS_ALREADY_EXIST;
		exceptionMsg = e.getMessage();
		
	}catch(Exception e ) {
		errorMessage = JSON_PROCESSING_FAILED;
		exceptionMsg = e.getMessage();
	}
	return processResponse(errorMessage,exceptionMsg,response);
	}

	@DeleteMapping("/delete/trip/{tripId}")
	public ResponseEntity<ResponseMessage>  DeleteTrip(@PathVariable(value ="tripId") Long tripId) {
		try{
			tripservices.deleteTrip(tripId);
		}catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			tripId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			tripId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg,tripId);
		
		}
	}

