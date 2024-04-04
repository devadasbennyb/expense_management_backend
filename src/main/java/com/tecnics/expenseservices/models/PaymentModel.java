package com.tecnics.expenseservices.models;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "payment_Table")
public class PaymentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payId;

	@Column(nullable = false, unique = true)
	private String paymentName;

	@Column(nullable = false)
	private String paymentDescription;

	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;

	public PaymentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentModel(Long payId, String paymentName, String paymentDescription, Timestamp created,
			Timestamp updated) {
		super();
		this.payId = payId;
		this.paymentName = paymentName;
		this.paymentDescription = paymentDescription;
		this.created = created;
		this.updated = updated;
	}

	public Long getPayId() {
		return payId;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
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

}
