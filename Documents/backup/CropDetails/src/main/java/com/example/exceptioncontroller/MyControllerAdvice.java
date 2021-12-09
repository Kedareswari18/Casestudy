package com.example.exceptioncontroller;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.customexception.CropDetailsNotFoundException;
import com.example.customexception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handelEmptyInput(EmptyInputException emptyInputExceptions){
	return new ResponseEntity<String>(emptyInputExceptions.getErrMsg(), null, HttpStatus.SC_BAD_REQUEST);
	}


	@ExceptionHandler(CropDetailsNotFoundException.class)
	public ResponseEntity<String> handelNoSuchElement(CropDetailsNotFoundException cropDetailsNotFoundException){
	return new ResponseEntity<String>(cropDetailsNotFoundException.getErrMsg(), null, HttpStatus.SC_BAD_REQUEST);
	}

}
