package com.example.exceptioncontroller;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.example.customexception.ItemException;
import com.example.customexception.OrderServiceException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(OrderServiceException.class)
	public ResponseEntity<String> handelEmptyInput(OrderServiceException orderServiceException){
	return new ResponseEntity<String>(orderServiceException.getErrMsg(), null, HttpStatus.SC_BAD_REQUEST);
	}
	
}
