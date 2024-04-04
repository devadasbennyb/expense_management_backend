//package com.tecnics.expenseservices.repositories;
//
//import com.tecnics.expenseservices.models.HomeModel;
//import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface HomeRepository extends JpaRepository<HomeModel, Long> {
//	
//  List<HomeModel> findAll();
//
//  HomeModel findByUserId(Long userId);
//
//  HomeModel findByUsername(String username);
//
//  @Query(value = "select * from user_new ", nativeQuery = true)
//  List<HomeModel> fetchUsers();
//}
