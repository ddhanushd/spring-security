package com.investor.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globallyException(Exception ex,WebRequest request)
	{
		Error error=new Error(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
