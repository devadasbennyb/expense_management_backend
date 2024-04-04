package com.tecnics.expenseservices.dtos;

import java.sql.Timestamp;

public class PaymentDto  {

	private Long payId;

	private String paymentName;

	private String paymentDescription;

	private Timestamp created;

	private Timestamp updated;
	
	

	public PaymentDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public PaymentDto(Long payId, String paymentName, String paymentDescription, Timestamp created, Timestamp updated) {
		super();
		this.payId = payId;
		this.paymentName = paymentName;
		this.paymentDescription = paymentDescription;
		this.created = created;
		this.updated = updated;
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

	@Override
	public String toString() {
		return "PaymentDto [payId=" + payId + ", paymentName=" + paymentName + ", paymentDescription="
				+ paymentDescription + ", created=" + created + ", updated=" + updated + "]";
	}
	

}
