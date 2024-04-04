package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.ExpenseDto;
import com.tecnics.expenseservices.models.ExpenseModel;
import com.tecnics.expenseservices.repositories.ExpenseRepositories;
import com.tecnics.expenseservices.services.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepositories expenseRepo;

	ModelMapper modelMapper = new ModelMapper();

	// Get Method
	@Override
	public List<ExpenseDto> getAllExpenses() {
		List<ExpenseDto> expenseDto = new ArrayList<ExpenseDto>();
		expenseRepo.findAll().forEach(expenseModel -> expenseDto.add(modelMapper.map(expenseModel, ExpenseDto.class)));
		return expenseDto;
	}

	// Get Method
	@Override
	public ExpenseDto getExpenseById(Long ExpId) {
		ExpenseModel expensemodel = expenseRepo.findByExpId(ExpId);
		if (expensemodel != null) {
			return modelMapper.map(expensemodel, ExpenseDto.class);
		} else
			return new ExpenseDto();

	}

	// Get Method
	@Override
	public ExpenseDto getExpensesByName(String merchant) {

		ExpenseModel expenseModel = expenseRepo.findByMerchant(merchant);

		if (expenseModel != null) {
			return modelMapper.map(expenseModel, ExpenseDto.class);
		} else {
			return null;
		}
	}

	// Post Method
	@Override
	public ExpenseDto addExpense(ExpenseDto expenseDto) {

		return modelMapper.map(expenseRepo.save(modelMapper.map(expenseDto, ExpenseModel.class)), ExpenseDto.class);
	}

	// Put Method
	@Override
	public ExpenseDto updateExpense(ExpenseDto expenseDto) {

		ExpenseModel expenseModel = expenseRepo.findByExpId(expenseDto.getExpId());
		if (expenseModel != null) {
			
			if(expenseDto.getDate() != null) {
				expenseModel.setDate(expenseDto.getDate());
			}
			if (expenseDto.getMerchant() != null) {
				expenseModel.setMerchant(expenseDto.getMerchant());
			}
			if (expenseDto.getAmount() != null) {
				expenseModel.setAmount(expenseDto.getAmount());
			}
			if (expenseDto.getCurrency() != null) {
				expenseModel.setCurrency(expenseDto.getCurrency());
			}
			if(expenseDto.getDescription() != null) {
				expenseModel.setDescription(expenseDto.getDescription());
			}
			expenseModel.setUpdated(new Timestamp(0));
			expenseRepo.save(expenseModel);
			return modelMapper.map(expenseModel, ExpenseDto.class);
		} else
			return null;
	}

	// Delete Method
	@Override
	public void deleteExpense(Long expId) {
		expenseRepo.deleteById(expId);

	}
}
