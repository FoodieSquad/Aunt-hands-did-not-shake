package com.niit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.niit.exception.RecordNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

	@ExceptionHandler(RecordNotFoundException.class)
	public String handleNotFound() {
		
		return"errorPage";
	}
}

