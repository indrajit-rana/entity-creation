package com.ty.entitycreation.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler /* extends ResponseEntityExceptionHandler */ {
//
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("timestamp", new Date());
//		map.put("status", status.value());
//
//		List<String> allErrors = ex.getAllErrors().stream().map(x -> x.getDefaultMessage())
//				.collect(Collectors.toList());
//		
//		map.put("errors", allErrors);
//		
//		return new ResponseEntity<Object>(map, status);
//	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> throwExceptions(MethodArgumentNotValidException exception) {
		return new ResponseEntity<>(exception.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList()),HttpStatus.BAD_REQUEST);
	}
}
