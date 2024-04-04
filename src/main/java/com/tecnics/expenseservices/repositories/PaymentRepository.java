package com.tecnics.expenseservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnics.expenseservices.models.PaymentModel;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {

	List<PaymentModel> findAll();

	@Query(value = "Select * from payment_table where payment_name=:PaymentName", nativeQuery = true)
	PaymentModel FindByPaymentName(String PaymentName);

	@Query(value = "Select * from payment_table where pay_id=:PayId", nativeQuery = true)
	PaymentModel FindByPayId(Long PayId);

}
