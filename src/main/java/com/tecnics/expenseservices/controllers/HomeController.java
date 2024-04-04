//package com.tecnics.expenseservices.controllers;
//
//import com.tecnics.expenseservices.dtos.HomeDto;
//import com.tecnics.expenseservices.models.HomeModel;
//import com.tecnics.expenseservices.services.HomeService;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HomeController {
//
//  @Autowired
//  private HomeService homeService;
//
//
//  @GetMapping("/hello")
//  private String hello() {
//	  return homeService.hello(); 
//  }
//  
//  @GetMapping("/getdatafromdb")
//  private List<HomeDto> getDataFromDB() {
//    return homeService.getDataFromDB();
//  }
//
//  @GetMapping("/getuser/{userId}")
//  private HomeDto getUserById1(@PathVariable Long userId) {
//    return homeService.getUserById(userId);
//  }
//
//  @GetMapping("/findByUsername/{username}")
//  private HomeDto findByUsername(@PathVariable String username) {
//    return homeService.findByUsername(username);
//  }
//
////  @PostMapping("/getuser")
////  private HomeDto getUserById2(@RequestBody Long userId) {
////    return homeService.getUserById(userId);
// // }
//
//  @PostMapping("/adduser")
//  private HomeDto addUser(@RequestBody HomeDto user) {
//    return homeService.addUser(user);
//  }
//
//  @PostMapping("/adduser2")
//  private HomeDto addUser(@RequestBody HomeModel user) {
//    return homeService.addUser2(user);
//  }
//}
