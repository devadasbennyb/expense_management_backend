package com.tecnics.expenseservices.repositories;

import com.tecnics.expenseservices.models.ExpenseModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepositories
  extends JpaRepository<ExpenseModel, Long> {
  List<ExpenseModel> findAll();

   ExpenseModel findByExpId(Long expId);

   ExpenseModel findByMerchant(String Merchant);

  @Query(value = "select * from Expense", nativeQuery = true)
  List<ExpenseModel> fetchExpense();
}
