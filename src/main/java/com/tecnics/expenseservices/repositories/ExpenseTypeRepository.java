package com.tecnics.expenseservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnics.expenseservices.models.ExpenseTypeModel;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseTypeModel, Long> {

	List<ExpenseTypeModel> findAll();

	ExpenseTypeModel findByExpenseType(String expenseType);

	ExpenseTypeModel findByExpenseTypeId(Long expenseTypeId);

	@Query(value = "select * from expensetype_table", nativeQuery = true)
	List<ExpenseTypeModel> fetchExpenseType();

}
