package com.tecnics.expenseservices.services;

import java.util.List;

import com.tecnics.expenseservices.dtos.AdvancesDto;

public interface AdvancesServices {
	
	public List<AdvancesDto> getAllAdvances();
	
	public AdvancesDto getAdvancesByAdvancesId(Long AdvancesId);
	
	public AdvancesDto getAdvancesByAdvanceName(String AdvancesName);
	
	public AdvancesDto createAdvance(AdvancesDto advances);
	
	public AdvancesDto updateAdvances(AdvancesDto advances);
	
	public void deleteAdvances(Long AdvancesId);


}
