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
@Table(name = "trip_table")
public class TripModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tripId;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private EmployeeModel employeeModel;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false, unique = true)
	private String tripName;

	@Column(nullable = false)
	private Date startDate;

	@Column(nullable = false)
	private Date endDate;

	@Column(nullable = false)
	private String fromLocation;

	@Column(nullable = false)
	private String toLocation;

	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Status status;

	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;

	public TripModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TripModel(Long tripId, EmployeeModel employeeModel, Date date, String tripName, Date startDate, Date endDate,
			String fromLocation, String toLocation, String description, Status status, Timestamp created,
			Timestamp updated) {
		super();
		this.tripId = tripId;
		this.employeeModel = employeeModel;
		this.date = date;
		this.tripName = tripName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
