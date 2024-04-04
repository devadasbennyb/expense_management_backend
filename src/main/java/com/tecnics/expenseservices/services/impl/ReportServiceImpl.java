package com.tecnics.expenseservices.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnics.expenseservices.dtos.ReportDto;
import com.tecnics.expenseservices.models.ReportModel;
import com.tecnics.expenseservices.repositories.ReportRepository;
import com.tecnics.expenseservices.services.ReportServices;

@Service
public class ReportServiceImpl implements ReportServices {

	// private static final Logger log = (Logger)
	// LoggerFactory.getLogger(TripServicesImpl.class);

	@Autowired
	private ReportRepository reportrepo;
	ModelMapper modelMapper = new ModelMapper();

	// Get Method
	@Override
	public List<ReportDto> getReportDetails() {
		List<ReportDto> ReportDto = new ArrayList<ReportDto>();
		reportrepo.findAll().forEach(ReportModel -> ReportDto.add(modelMapper.map(ReportModel, ReportDto.class)));

		return ReportDto;
	}

	// Get Method
	@Override
	public ReportDto getReportById(Long ReportId) {
		ReportModel reportModel = reportrepo.findByReportId(ReportId);
		if (reportModel != null) {
			return modelMapper.map(reportModel, ReportDto.class);
		}
		return new ReportDto();

	}
	
	

	// Post Method
	@Override
	public ReportDto createReport(ReportDto report) {

		return modelMapper.map
				(reportrepo.save(modelMapper.map(report, ReportModel.class)), ReportDto.class);

	}

	// Put Method
	@Override
	public ReportDto updateReport(ReportDto reportDto) {
		
		ReportModel reportModel = reportrepo.findByReportId(reportDto.getReportId());
		if(reportModel != null) {
			if(reportDto.getReportName() != null) {
				reportModel.setReportName(reportDto.getReportName());
			}if(reportDto.getStatus() != null) {
				reportModel.setStatus(reportDto.getStatus());
			}if(reportDto.getDuration() != null) {
				reportModel.setDuration(reportDto.getDuration());
			}if(reportDto.getDescription() != null) {
				reportModel.setDescription(reportDto.getDescription());
			}
			reportModel.setUpdated(new Timestamp(0));
			reportrepo.save(reportModel);
			return modelMapper.map(reportModel, ReportDto.class);
			
		}else return null;
	}

	// Delete Method
	@Override
	public void deleteReport(Long reportId) {

		reportrepo.deleteById(reportId);
	}

	@Override
	public ReportDto getReportByName(String reportName) {
		
		ReportModel reportModel = reportrepo.findByReportName(reportName);
		
		if(reportModel != null) {
			return modelMapper.map(reportModel, ReportDto.class);
			
		}else
			
		return null;
	}

}
