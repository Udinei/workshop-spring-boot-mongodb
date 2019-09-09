package com.udineisilva.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.udineisilva.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	// Ao ser lancada essa execao ObjectNotFoundException sera retornado um obj StandardError
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		//new StandardError(timestamp, status, error, message, path)
		StandardError err = new StandardError(System.currentTimeMillis(),
				status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
