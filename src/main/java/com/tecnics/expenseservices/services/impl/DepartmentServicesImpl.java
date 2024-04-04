package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.DepartmentDto;
import com.tecnics.expenseservices.models.DepartmentModel;
import com.tecnics.expenseservices.repositories.DepartmentRepository;
import com.tecnics.expenseservices.services.DepartmentServices;

@Service
public class DepartmentServicesImpl implements DepartmentServices {

	@Autowired
	public DepartmentRepository departmentrepo;
	
	ModelMapper modelMapper = new ModelMapper();

	// Get Method
	@Override
	public List<DepartmentDto> getDepartmentDetails() {

		List<DepartmentDto> departmentdto = new ArrayList<DepartmentDto>();

		departmentrepo.findAll()
								.forEach(
										departmentmodel ->
														 departmentdto.add(modelMapper.map(departmentmodel, DepartmentDto.class)));

		return departmentdto;
	}

	// Get Method
	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {
		
		DepartmentModel DepartmentModel = departmentrepo.findByDepartmentId(departmentId);
		
		if (DepartmentModel != null) {
			return modelMapper.map(DepartmentModel, DepartmentDto.class);
		} else
			return null;
	}

	// Post Method
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {

		return modelMapper.map(
				departmentrepo.save(
						modelMapper.map(departmentDto, DepartmentModel.class)),DepartmentDto.class);

	}

	// Put method
	@Override
	public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
		DepartmentModel dto=departmentrepo.findByDepartmentId(departmentDto.getDepartmentId());
		if(dto != null) {
//			DepartmentModel ddto=dto.get();
			if(departmentDto.getDepartmentName() != null) {
			dto.setDepartmentName(departmentDto.getDepartmentName());
			}
			if(departmentDto.getDepartmentDescription() !=null) {
			dto.setDepartmentDescription(departmentDto.getDepartmentDescription());
			}
			dto.setUpdated(new Timestamp(0));
			departmentrepo.save(dto);
//			return departmentDto;
		return modelMapper.map(dto, DepartmentDto.class);
	}else
	{
		return null;
	}
	}
	

	// Delete method
	@Override
	public void deleteDepartment(Long DeprtId) {
		departmentrepo.deleteById(DeprtId);

	}

	@Override
	public DepartmentDto getDepartmentByName(String departmentName) {
		
		DepartmentModel departmentModel = departmentrepo.findByDepartmentName(departmentName);
		
		if(departmentModel != null) {
			return modelMapper.map(departmentModel, DepartmentDto.class);
		}else return null;
	}
	

}
