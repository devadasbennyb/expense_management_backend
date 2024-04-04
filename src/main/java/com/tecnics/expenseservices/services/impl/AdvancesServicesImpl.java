package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.AdvancesDto;
import com.tecnics.expenseservices.models.AdvancesModel;
import com.tecnics.expenseservices.repositories.AdvancesRepository;
import com.tecnics.expenseservices.services.AdvancesServices;

@Service
public class AdvancesServicesImpl implements AdvancesServices {

	@Autowired
	AdvancesRepository advancesRepo;
	ModelMapper modelMapper = new ModelMapper();

	// Get method
	@Override
	public List<AdvancesDto> getAllAdvances() {

		List<AdvancesDto> advancesdto = new ArrayList<AdvancesDto>();
		advancesRepo.findAll()
				.forEach(advancesmodel -> advancesdto.add(modelMapper.map(advancesmodel, AdvancesDto.class)));

		return advancesdto;
	}

	// Get method
	@Override
	public AdvancesDto getAdvancesByAdvancesId(Long advancesId) {
		AdvancesModel advancesModel = advancesRepo.findByAdvanceId(advancesId);

		if (advancesModel != null) {
			return modelMapper.map(advancesModel, AdvancesDto.class);
		} else
			return null;

	}

	// Get method
	@Override
	public AdvancesDto getAdvancesByAdvanceName(String advancesName) {

		AdvancesModel advanceModel = advancesRepo.findByAdvanceName(advancesName);
		if (advanceModel != null) {
			return modelMapper.map(advanceModel, AdvancesDto.class);
		} else
			return null;

	}

	// Post method
	@Override
	public AdvancesDto createAdvance(AdvancesDto advancesDto) {
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(advancesRepo.save(modelMapper.map(advancesDto, AdvancesModel.class)), AdvancesDto.class);

	}

	// Put method
	@Override
	public AdvancesDto updateAdvances(AdvancesDto advancesDto) {
		AdvancesModel advancesModel = advancesRepo.findByAdvanceId(advancesDto.getAdvanceId());
		if (advancesModel != null) {
			if (advancesDto.getAdvanceName() != null) {
				advancesModel.setAdvanceName(advancesDto.getAdvanceName());
			}
			if (advancesDto.getDate() != null) {
				advancesModel.setDate(advancesDto.getDate());
			}
			if (advancesDto.getAmount() != null) {
				advancesModel.setAmount(advancesDto.getAmount());
			}
			if (advancesDto.getDescription() != null) {
				advancesModel.setDescription(advancesDto.getDescription());
			}
			if (advancesDto.getStatus() != null) {
				advancesModel.setStatus(advancesDto.getStatus());
			}
			advancesModel.setUpdated(new Timestamp(0));
			advancesRepo.save(advancesModel);
			return modelMapper.map(advancesModel, AdvancesDto.class);
		} else {
			return null;
		}

	}

	// Delete method
	@Override
	public void deleteAdvances(Long advancesId) {
		advancesRepo.deleteById(advancesId);

	}

}
