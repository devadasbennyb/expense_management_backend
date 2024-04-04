package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.ExpenseTypeDto;
import com.tecnics.expenseservices.models.ExpenseTypeModel;
import com.tecnics.expenseservices.repositories.ExpenseTypeRepository;
import com.tecnics.expenseservices.services.ExpenseTypeServices;

@Service
public class ExpenseTypeServicesImpl implements ExpenseTypeServices {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	public ExpenseTypeRepository expenseTypeRepo;

	@Override
	public List<ExpenseTypeDto> getExpenseAllTypes() {
		List<ExpenseTypeDto> expensetypeDto = new ArrayList<ExpenseTypeDto>();
		expenseTypeRepo.findAll().forEach(
				expensetypeModel -> expensetypeDto.add(modelMapper.map(expensetypeModel, ExpenseTypeDto.class)));

		return expensetypeDto;
	}

	@Override
	public ExpenseTypeDto getExpenseTypeById(Long ExpenseTypeId) {
		ExpenseTypeModel expenseTypeModel = expenseTypeRepo.findByExpenseTypeId(ExpenseTypeId);
		if (expenseTypeModel != null) {
			return modelMapper.map(expenseTypeModel, ExpenseTypeDto.class);
		} else
			return null;
	}

	@Override
	public ExpenseTypeDto getByExpenseType(String expenseType) {

		ExpenseTypeModel expenseTypeModel = expenseTypeRepo.findByExpenseType(expenseType);

		if (expenseTypeModel != null) {
			return modelMapper.map(expenseTypeModel, ExpenseTypeDto.class);
		} else
			return null;
	}

	@Override
	public ExpenseTypeDto createExpenseType(ExpenseTypeDto expenseType) {
		return modelMapper.map(expenseTypeRepo.save(modelMapper.map(expenseType, ExpenseTypeModel.class)),
				ExpenseTypeDto.class);

	}

	@Override
	public ExpenseTypeDto updateExpenseType(ExpenseTypeDto expenseTypeDto) {
		ExpenseTypeModel expenseTypeModel = expenseTypeRepo.findByExpenseTypeId(expenseTypeDto.getExpenseTypeId());
		if (expenseTypeModel != null) {
			if (expenseTypeDto.getExpenseType() != null) {
				expenseTypeModel.setExpenseType(expenseTypeDto.getExpenseType());
			}
			if (expenseTypeDto.getDescription() != null) {
				expenseTypeModel.setDescription(expenseTypeDto.getDescription());
			}
			expenseTypeDto.setUpdated(new Timestamp(0));
			expenseTypeRepo.save(expenseTypeModel);

			return modelMapper.map(expenseTypeModel, ExpenseTypeDto.class);

		} else
			return null;

	}

	@Override
	public String deleteExpenseType(Long ExpenseTypeId) {
		expenseTypeRepo.deleteById(ExpenseTypeId);
		return "Successfully Deleted";
	}

}
