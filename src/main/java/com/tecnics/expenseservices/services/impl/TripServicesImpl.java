package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.TripDto;
import com.tecnics.expenseservices.models.TripModel;
import com.tecnics.expenseservices.repositories.TripRepository;
import com.tecnics.expenseservices.services.TripServices;

@Service
public class TripServicesImpl implements TripServices {


	@Autowired
	public TripRepository triprepo;
	
	ModelMapper modelmapper = new ModelMapper();

	// Get Method
	@Override
	public List<TripDto> getTripDetails() {
		List<TripDto> tripDto = new ArrayList<TripDto>();
		triprepo.findAll().forEach(tripModel -> tripDto.add(modelmapper.map(tripModel, TripDto.class)));
		return tripDto;
	}

	// Get Method
	@Override
	public TripDto getTripById(Long TripId) {
		TripModel tripModel = triprepo.findByTripId(TripId);
		if (tripModel != null) {
			return modelmapper.map(tripModel, TripDto.class);
		}
		return new TripDto();
	}
	
  

	// Post Method
	@Override
	public TripDto createTrip(TripDto trip) {
		ModelMapper modelmapper = new ModelMapper();

		return modelmapper.map(triprepo.save(modelmapper.map(trip, TripModel.class)), TripDto.class);
	}

	// Put Method
	@Override
	public TripDto updateTrip(TripDto tripDto) {
		TripModel tripModel = triprepo.findByTripId(tripDto.getTripId());
		if(tripModel != null) {
			if(tripDto.getTripName() != null) {
				tripModel.setTripName(tripDto.getTripName());
				
			}if(tripDto.getFromLocation() != null) {
				tripModel.setFromLocation(tripDto.getFromLocation());
				
			}if(tripDto.getToLocation() != null) {
				tripModel.setToLocation(tripDto.getToLocation());
				
			}if(tripDto.getStartDate() != null) {
				tripModel.setStartDate(tripDto.getStartDate());
				
			}if(tripDto.getEndDate() != null) {
				tripModel.setToLocation(tripDto.getToLocation());
			}
			tripModel.setUpdated(new Timestamp(0));
			triprepo.save(tripModel);
			return modelmapper.map(tripModel, TripDto.class);
			
		}else return null;

	}

	// Delete Method
	@Override
	public void deleteTrip(Long TripId) {

		triprepo.deleteById(TripId);

	}

	@Override
	public TripDto getTripByName(String TripName) {

		TripModel tripmodel = triprepo.findByTripName(TripName);
		
		if(tripmodel != null) 
		{
		return modelmapper.map(tripmodel, TripDto.class);
		}
		else return null;
	}

}
