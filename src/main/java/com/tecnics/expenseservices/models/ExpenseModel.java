package com.tecnics.expenseservices.models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.tecnics.expenseservices.utils.Status;

@Entity
@Table(name = "expense_table")
public class ExpenseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expId;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private String merchant;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private EmployeeModel employeeModel;

	@ManyToOne
	@JoinColumn(name = "expense_type_id")
	private ExpenseTypeModel expenseTypeModel;

	@ManyToOne
	@JoinColumn(name = "pay_id")
	private PaymentModel paymentModel;

	@Column(nullable = false)
	private Long amount;

	@Column(nullable = false)
	private String currency;

	private String description;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;

	public ExpenseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpenseModel(Long expId, Date date, String merchant, EmployeeModel employeeModel,
			ExpenseTypeModel expenseTypeModel, PaymentModel paymentModel, Long amount, String currency,
			String description, Status status, Timestamp created, Timestamp updated) {
		super();
		this.expId = expId;
		this.date = date;
		this.merchant = merchant;
		this.employeeModel = employeeModel;
		this.expenseTypeModel = expenseTypeModel;
		this.paymentModel = paymentModel;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		this.status = status;
		this.created = created;
		this.updated = updated;
	}

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
