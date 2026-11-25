package com.mx.app.exeption;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExeptionHandler {

	@ExceptionHandler
	public ResponseEntity<ApiError> recursoNoEncotradoExeption(RecursoNoEncotradoExeption ex, HttpServletRequest request){
		
		ApiError error = new ApiError();
		
		error.setFechaHora(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
		error.setMesage(ex.getMessage());
		error.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
