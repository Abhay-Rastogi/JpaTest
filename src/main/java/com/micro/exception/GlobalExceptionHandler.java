package com.micro.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
	

	private static final long serialVersionUID = -6940487000940979998L;

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ResponseExceptionMessage> handleCustomerNotFoundException(HttpServletRequest request, CustomerNotFoundException ex){
		
		ResponseExceptionMessage responseMessage = ResponseExceptionMessage.builder()
		.uri(request.getRequestURI())
		.message(ex.getMessage())
		.responseTimeStamp(new Date()).build();
		
		return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
	}

}
