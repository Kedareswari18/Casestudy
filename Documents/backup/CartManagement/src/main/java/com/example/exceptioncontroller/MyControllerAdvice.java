package com.example.exceptioncontroller;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.example.customexception.ItemException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<String> handelEmptyInput(ItemException itemException){
	return new ResponseEntity<String>(itemException.getErrMsg(), null, HttpStatus.SC_BAD_REQUEST);
	}
	
}
