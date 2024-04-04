package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.ManagerDto;
import com.tecnics.expenseservices.models.ManagerModel;
import com.tecnics.expenseservices.repositories.ManagerRepository;
import com.tecnics.expenseservices.services.ManagerServices;

@Service
public class ManagerServicesImpl implements ManagerServices {

	@Autowired
	private ManagerRepository managerRepo;
	ModelMapper modelMapper = new ModelMapper();

	// Get Method
	@Override
	public List<ManagerDto> getManagerDetails() {
		List<ManagerDto> managerdto = new ArrayList<ManagerDto>();
		managerRepo.findAll().forEach(
				managermodel -> managerdto.add(modelMapper.map(managermodel, ManagerDto.class)));
		return managerdto;

	}

	// Get Method
	@Override
	public ManagerDto getManagerById(Long managerId) {
		ManagerModel managermodel = managerRepo.findByManagerId(managerId);
		if (managermodel != null) {
			return modelMapper.map(managermodel, ManagerDto.class);
		} else
			return null;

	}

	// Get Method
	@Override
	public ManagerDto getManagerByName(String managerName) {

		ManagerModel managermodel = managerRepo.findByManagerName(managerName);
		
			if(managermodel != null) {
		return modelMapper.map(managermodel, ManagerDto.class);
			}else
				return null;
	}

	// Post Method
	@Override
	public ManagerDto createManager(ManagerDto manager) {
		return modelMapper.map(
				managerRepo.save(modelMapper.map(manager, ManagerModel.class)), ManagerDto.class);

	}

	// Put Method
	@Override
	public ManagerDto updateManager(ManagerDto managerDto) {
		ManagerModel managerModel = managerRepo.findByManagerId(managerDto.getManagerId());
		if(managerModel != null) {
			if(managerDto.getManagerName() != null) {
				managerModel.setManagerName(managerDto.getManagerName());
			}managerDto.setUpdated(new Timestamp(0));
			managerRepo.save(managerModel);
			return modelMapper.map(managerModel, ManagerDto.class);
		}else return null;
	}

	// Delete Method
	@Override
	public void deleteManager(Long managerId) {
		managerRepo.deleteById(managerId);
	}

}
