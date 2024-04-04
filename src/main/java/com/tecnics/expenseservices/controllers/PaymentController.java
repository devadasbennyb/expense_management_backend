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

import com.tecnics.expenseservices.dtos.PaymentDto;
import com.tecnics.expenseservices.services.PaymentServices;
import com.tecnics.expenseservices.utils.ResponseMessage;

@RestController
public class PaymentController {

	String errorMessage = null;
	String exceptionMsg = null;

	@Autowired
	public PaymentServices paymentServices;

	@GetMapping("/fetch/payments")
	public ResponseEntity<ResponseMessage> getAllPayments() {
		List<PaymentDto> response = null;
		try {
			response = paymentServices.getAllPayments();
			if (response == null || response.isEmpty()) {
				response=null;
				errorMessage = NO_RECORD_FOUND;
			}
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();
		}
		return processResponse(errorMessage, exceptionMsg, response);

	}

	@GetMapping("/fetch/payment/{payId}")
	public PaymentDto getPaymentById(@PathVariable Long payId){
		return paymentServices.getByPayId(payId);
		
	} 
	@GetMapping("/fetch/paymentByName/{paymentName}")
	public PaymentDto getPaymentByPaymentName(@PathVariable String paymentName){
		return paymentServices.getByPaymentName(paymentName);
		
	} 
	
	@PostMapping("/save/payment")
	public ResponseEntity<ResponseMessage> createPayment(@RequestBody PaymentDto payment) {
		PaymentDto response = null;
		try {
			response = paymentServices.createPayment(payment);

		} catch (DataIntegrityViolationException e) {
			errorMessage = RECORD_IS_ALREADY_EXIST;
			exceptionMsg = e.getMessage();
		} catch (Exception e) {
			errorMessage = JSON_PROCESSING_FAILED;
			exceptionMsg = e.getMessage();

		}
		return processResponse(errorMessage, exceptionMsg, response);

	}

	@PutMapping("/update/payment")
	public ResponseEntity<ResponseMessage> updatePayment(@RequestBody PaymentDto payment) {
		PaymentDto response = null;
		try {
			response = paymentServices.updatePayment(payment);
			if(response == null) {
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

	@DeleteMapping("/delete/payment/{PaymentId}")
	public  ResponseEntity<ResponseMessage> deletePayment(@PathVariable(value ="PaymentId") Long PaymentId) {
		try { paymentServices.deletePayment(PaymentId);
		}catch (EmptyResultDataAccessException e) {
			errorMessage = NO_RECORD_FOUND;
			exceptionMsg = e.getMessage();
			PaymentId = null;
		} catch (DataIntegrityViolationException e) {
			errorMessage = "Unable to delete due to FK error";
			exceptionMsg = e.getMessage();
			PaymentId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processResponse(errorMessage, exceptionMsg,PaymentId);
		}
		
	}
