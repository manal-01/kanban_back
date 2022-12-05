package org.rygn.kanban.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.ValidationException;
import javax.xml.bind.util.ValidationEventCollector;

import org.springframework.boot.context.properties.bind.validation.ValidationBindHandler;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice



public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																	HttpHeaders headers, 
																	HttpStatus status, 
																	WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestmp", new Date());
        body.put("status", status.value());
        
        List<ValidationErrors> errors = new ArrayList<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {        	
        	errors.add(new ValidationException(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        
        
        
        Comparator<ValidationError> comparator = new Comparator<ValidationError>() {

			@Override
			public int compare(ValidationError err0, ValidationError err1) {
				
				return err0.getField().compareTo(err1.getField());
			}
        	
		};
        
}
}