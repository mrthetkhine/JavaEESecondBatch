package com.example.demo.exeception_handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	  public void assertionException(final Exception e) {
		System.out.println("Global exception handler run "+e.getMessage());
	  }
}
