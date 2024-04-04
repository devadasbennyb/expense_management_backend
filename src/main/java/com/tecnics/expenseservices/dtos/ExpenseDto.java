package com.tecnics.expenseservices.dtos;

import java.sql.Date;
import java.sql.Timestamp;

import com.tecnics.expenseservices.models.EmployeeModel;
import com.tecnics.expenseservices.models.ExpenseTypeModel;
import com.tecnics.expenseservices.models.PaymentModel;
import com.tecnics.expenseservices.utils.Status;

public class ExpenseDto {

	private Long expId;

	private Date date;

	private String merchant;

	private EmployeeModel employeeModel;

	private ExpenseTypeModel expenseTypeModel;

	private PaymentModel paymentModel;

	private Long amount;

	private String description;

	private String currency;

	private Status status;

	private Timestamp created;

	private Timestamp updated;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getExpId() {
		return expId;
	}

	public void setExpId(Long expId) {
		this.expId = expId;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}

	public ExpenseTypeModel getExpenseTypeModel() {
		return expenseTypeModel;
	}

	public void setExpenseTypeModel(ExpenseTypeModel expenseTypeModel) {
		this.expenseTypeModel = expenseTypeModel;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public PaymentModel getPaymentModel() {
		return paymentModel;
	}

	public void setPaymentModel(PaymentModel paymentModel) {
		this.paymentModel = paymentModel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}



}
