package com.tecnics.expenseservices.services;

import java.util.List;

import com.tecnics.expenseservices.dtos.ExpenseDto;

public interface ExpenseService {

	public List<ExpenseDto> getAllExpenses();

	public ExpenseDto getExpenseById(Long ExpId);

	public ExpenseDto getExpensesByName(String merchant);

	public ExpenseDto addExpense(ExpenseDto expenseDto);

	public void deleteExpense(Long expId);

	public ExpenseDto updateExpense(ExpenseDto expenseDto);

}
