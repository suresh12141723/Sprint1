package com.cg.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserExceptionController {
	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<Object> handleException(UserException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	//@ExceptionHandler(value = NoShowIdFoundException.class)
	//public ResponseEntity<Object> handleException(NoShowIdFoundException exception) {
		//return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	//}

}
