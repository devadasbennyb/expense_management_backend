package com.tecnics.expenseservices.controllers;

import static com.tecnics.expenseservices.utils.Constants.*;
import static com.tecnics.expenseservices.utils.ResponseUtility.processResponse;

import com.tecnics.expenseservices.dtos.DepartmentDTO;
import com.tecnics.expenseservices.services.DepartmentService;
import com.tecnics.expenseservices.utils.ResponseMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

  @Autowired
  DepartmentService departmentService;

  String errorMessage = null;
  String exceptionMsg = null;

  @GetMapping("/fetch/department/{id}")
  public ResponseEntity<ResponseMessage> getHome(
    @PathVariable(value = "id") Long departmentId
  ) {
    DepartmentDTO response = null;
    try {
      response = departmentService.fetchDepartmentById(departmentId);
      if (response == null) {
        errorMessage = NO_RECORD_FOUND;
      }
    } catch (Exception e) {
      errorMessage = JSON_PROCESSING_FAILED;
      exceptionMsg = e.getMessage();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }

  @GetMapping("/fetch/departments")
  public ResponseEntity<ResponseMessage> fetchDepartments() {
    List<DepartmentDTO> response = null;
    try {
      response = departmentService.fetchDepartments();
      if (response == null) {
        errorMessage = NO_RECORD_FOUND;
      }
    } catch (Exception e) {
      errorMessage = JSON_PROCESSING_FAILED;
      exceptionMsg = e.getMessage();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }

  @PostMapping("/save/department")
  public ResponseEntity<ResponseMessage> saveEmployee(
    @RequestBody DepartmentDTO departmentModel
  ) {
    DepartmentDTO response = null;
    try {
      response = departmentService.saveDepartment(departmentModel);
    } catch (DataIntegrityViolationException e) {
      errorMessage = RECORD_IS_ALREADY_EXIST;
      exceptionMsg = e.getMessage();
    } catch (Exception e) {
      errorMessage = JSON_PROCESSING_FAILED;
      exceptionMsg = e.getMessage();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }
}
