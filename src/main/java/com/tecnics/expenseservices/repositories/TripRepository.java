package com.tecnics.expenseservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnics.expenseservices.models.TripModel;

@Repository
public interface TripRepository extends JpaRepository<TripModel, Long>{
	
	List<TripModel> findAll();
	
	TripModel findByTripId(Long TripId);
	
	TripModel findByTripName(String TripName);
	
	@Query(value = "select * from trip",nativeQuery = true)
	List<TripModel>fetchTrip();
	
}