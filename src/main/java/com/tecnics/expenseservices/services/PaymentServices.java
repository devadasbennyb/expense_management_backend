package com.tecnics.expenseservices.services;

import java.util.List;

import com.tecnics.expenseservices.dtos.PaymentDto;

public interface PaymentServices {

	public List<PaymentDto> getAllPayments();

	public PaymentDto getByPayId(Long paymentId);

	public PaymentDto getByPaymentName(String paymentName);

	public PaymentDto createPayment(PaymentDto payment);

	public PaymentDto updatePayment(PaymentDto payment);

	public String deletePayment(Long PaymentId);

}
