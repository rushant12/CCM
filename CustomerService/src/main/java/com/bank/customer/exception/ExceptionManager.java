package com.bank.customer.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler  (value = InvalidDetails.class)
	public ResponseEntity<ExceptionDTO> invalidDetails(InvalidDetails exception, HttpServletRequest request)
	{
		ExceptionDTO exceptionDTO = new ExceptionDTO();
		exceptionDTO.setMessage(exception.getMessage());
		exceptionDTO.setUrl(request.getRequestURI());
		return new ResponseEntity<ExceptionDTO>(exceptionDTO, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler  (value = CustomerAlreadyExist.class)
	public ResponseEntity<ExceptionDTO> customerAlreadyExist(CustomerAlreadyExist exception, HttpServletRequest request)
	{
		ExceptionDTO exceptionDTO = new ExceptionDTO();
		exceptionDTO.setMessage(exception.getMessage());
		exceptionDTO.setUrl(request.getRequestURI());
		return new ResponseEntity<ExceptionDTO>(exceptionDTO, HttpStatus.CONFLICT);
	}

}
