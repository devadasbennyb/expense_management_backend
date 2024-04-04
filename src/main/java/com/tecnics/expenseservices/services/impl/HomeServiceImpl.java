//package com.tecnics.expenseservices.services.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.tecnics.expenseservices.dtos.HomeDto;
//import com.tecnics.expenseservices.models.HomeModel;
//import com.tecnics.expenseservices.repositories.HomeRepository;
//import com.tecnics.expenseservices.services.HomeService;
//
//@Service
//public class HomeServiceImpl implements HomeService {
//
//	// private static final Logger log = LoggerFactory.getLogger(
//	// HomeServiceImpl.class
//	// );
//
//	@Autowired
//	private HomeRepository homeRepo;
//
//	@Override
//	public String hello() {
//		return "data from service";
//	}
//
//	// Get Method
//	@Override
//	public List<HomeDto> getDataFromDB() {
//		ModelMapper modelMapper = new ModelMapper();
//		List<HomeDto> homeDtos = new ArrayList<HomeDto>();
//		homeRepo.findAll().forEach(homeModel -> homeDtos.add(modelMapper.map(homeModel, HomeDto.class)));
//
//		return homeDtos;
//	}
//
//	// Get Method
//	@Override
//	public HomeDto getUserById(Long userId) {
//		ModelMapper modelMapper = new ModelMapper();
//		HomeModel homeModel = homeRepo.findByUserId(userId);
//		if (homeModel != null) {
//			return modelMapper.map(homeModel, HomeDto.class);
//		} else
//			return new HomeDto();
//	}
//
//	// Get Method
//	@Override
//	public HomeDto findByUsername(String username) {
//		ModelMapper modelMapper = new ModelMapper();
//		return modelMapper.map(homeRepo.findByUsername(username), HomeDto.class);
//	}
//
//	// Post Method
//	@Override
//	public HomeDto addUser(HomeDto user) {
//		ModelMapper modelMapper = new ModelMapper();
//
//		return modelMapper.map(homeRepo.save(modelMapper.map(user, HomeModel.class)), HomeDto.class);
//	}
//
//	// Post Method
//	@Override
//	public HomeDto addUser2(HomeModel user) {
//		ModelMapper modelMapper = new ModelMapper();
//
//		return modelMapper.map(user, HomeDto.class);
//	}
//}
