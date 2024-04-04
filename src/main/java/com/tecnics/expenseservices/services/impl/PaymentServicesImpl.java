package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.PaymentDto;
import com.tecnics.expenseservices.models.PaymentModel;
import com.tecnics.expenseservices.repositories.PaymentRepository;
import com.tecnics.expenseservices.services.PaymentServices;

@Service
public class PaymentServicesImpl implements PaymentServices{
	
	@Autowired
	public PaymentRepository paymentRepo;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<PaymentDto> getAllPayments() {
	List<PaymentDto> paymentDto = new ArrayList<PaymentDto>();
	paymentRepo.findAll().forEach(
			paymentModel -> paymentDto.add(modelMapper.map(paymentModel, PaymentDto.class)));
		return paymentDto;
	}

	@Override
	public PaymentDto getByPayId(Long payId) {
		PaymentModel paymentmodel = paymentRepo.FindByPayId(payId);
		if(paymentmodel != null){
			return modelMapper.map(paymentmodel,PaymentDto.class);
		} 
		return new PaymentDto();
	}

	@Override
	public PaymentDto getByPaymentName(String paymentName) {
		return modelMapper.map(paymentRepo.FindByPaymentName(paymentName), PaymentDto.class);
	
	}

	@Override
	public PaymentDto createPayment(PaymentDto payment) {
		
		return modelMapper.map(
				paymentRepo.save(modelMapper.map(payment, PaymentModel.class)), PaymentDto.class);
	}

	@Override
	public PaymentDto updatePayment(PaymentDto paymentDto) {
		PaymentModel paymentModel = paymentRepo.FindByPayId(paymentDto.getPayId());
		if(paymentModel != null) {
			if(paymentDto.getPaymentName() != null) {
				paymentModel.setPaymentName(paymentDto.getPaymentName());
			}if(paymentDto.getPaymentDescription() != null) {
				paymentModel.setPaymentDescription(paymentDto.getPaymentDescription());
			}paymentModel.setUpdated(new Timestamp(0));
			paymentRepo.save(paymentModel);
			return modelMapper.map(paymentModel, PaymentDto.class);
		}else return null;
	}

	@Override
	public String deletePayment(Long PaymentId) {
		paymentRepo.deleteById(PaymentId);
		return "Delete Successfully";
		
	}

}
