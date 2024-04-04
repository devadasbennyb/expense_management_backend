package com.tecnics.expenseservices.controllers;

import static com.tecnics.expenseservices.utils.Constants.*;
import static com.tecnics.expenseservices.utils.ResponseUtility.processResponse;

import com.tecnics.expenseservices.dtos.EmployeeDTO;
import com.tecnics.expenseservices.services.EmployeeService;
import com.tecnics.expenseservices.utils.ResponseMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  String errorMessage = null;
  String exceptionMsg = null;

  @GetMapping("/fetch/employee/{id}")
  public ResponseEntity<ResponseMessage> fetchEmployeeById(
    @PathVariable(value = "id") Long employeeId
  ) {
    EmployeeDTO response = null;
    try {
      response = employeeService.fetchById(employeeId);
      if (response == null) {
        errorMessage = NO_RECORD_FOUND;
      }
    } catch (Exception e) {
      errorMessage = JSON_PROCESSING_FAILED;
      exceptionMsg = e.getMessage();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }

  @GetMapping("/fetch/employees")
  public ResponseEntity<ResponseMessage> fetchEmployees() {
    List<EmployeeDTO> response = null;
    try {
      response = employeeService.fetchEmployees();
      if (response == null) {
        errorMessage = NO_RECORD_FOUND;
      }
    } catch (Exception e) {
      errorMessage = JSON_PROCESSING_FAILED;
      exceptionMsg = e.getMessage();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }

  @PostMapping("/save/employee")
  public ResponseEntity<ResponseMessage> saveEmployee(
    @RequestBody EmployeeDTO employee
  ) {
    EmployeeDTO response = null;
    try {
      response = employeeService.save(employee);
    } catch (DataIntegrityViolationException e) {
      errorMessage = DATA_ERROR;
      exceptionMsg = e.getMessage();
    } catch (Exception e) {
      errorMessage = JSON_PROCESSING_FAILED;
      exceptionMsg = e.getMessage();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }
}
