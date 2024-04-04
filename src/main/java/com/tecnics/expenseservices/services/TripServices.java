package com.tecnics.expenseservices.services;

import java.util.List;

import com.tecnics.expenseservices.dtos.TripDto;

public interface TripServices {
	
	public List<TripDto> getTripDetails();

	public TripDto getTripById(Long TripId); 
	
	public TripDto getTripByName(String TripName);
	
	public TripDto createTrip(TripDto trip);
	
	public void deleteTrip(Long TripId);
	
	public TripDto updateTrip(TripDto trip);
	
	
}
