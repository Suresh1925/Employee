package com.onesoft.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class EmployeeException {
@ExceptionHandler(value=EmployeeNotFoundException.class)
public ResponseEntity<Object> getEmployeeException(){
	return new ResponseEntity<>("EmployeeNotFound",HttpStatus.NOT_FOUND);
}
@ExceptionHandler(value=EmployeeMissingException.class)
public ResponseEntity<Object> getEmpname(){
	return new ResponseEntity<>("EmployeeNameMissing",HttpStatus.NOT_FOUND);
}
}
