package com.example.Blog.GlobalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Blog.Exception.ResourceNotFound;


@RestControllerAdvice
public class GlobalException {

	@Autowired
	private ApiError error;
	
	@ExceptionHandler(value = ResourceNotFound.class)
	public ResponseEntity<ApiError> emptyInputException(){
		error.setError(" The blog you are looking for is not avilable");
		return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
	}
}
