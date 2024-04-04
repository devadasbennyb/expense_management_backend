package com.tecnics.expenseservices.services;

import java.util.List;

import com.tecnics.expenseservices.dtos.ExpenseTypeDto;

public interface ExpenseTypeServices {
	
	public List<ExpenseTypeDto> getExpenseAllTypes();
	
	public ExpenseTypeDto getExpenseTypeById(Long ExpenseTypeId);
	
	public ExpenseTypeDto getByExpenseType(String expenseType);
	
	public ExpenseTypeDto createExpenseType(ExpenseTypeDto expenseType);
	
	public ExpenseTypeDto updateExpenseType(ExpenseTypeDto expenseType);
	
	public String deleteExpenseType(Long ExpenseTypeId);

}
