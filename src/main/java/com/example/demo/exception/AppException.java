package com.example.demo.exception;


import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class AppException{
	private static final Logger LOGGER = LoggerFactory.getLogger(AppException.class);
	//product not found
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseMsg  handleIOException(ProductNotFoundException ex){
		ResponseMsg  ResponseMsg = new ResponseMsg(ex.getMessage());
		LOGGER.debug("Product not found!");
		return ResponseMsg;
	}
	
	//location not found
	@ExceptionHandler(LocationNotFoundException.class)
	public ResponseMsg  handleIOException(LocationNotFoundException ex){
		ResponseMsg  ResponseMsg = new ResponseMsg(ex.getMessage());
		LOGGER.debug("Location not found!");
		return ResponseMsg;
	}
	
	@ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse constraintViolationException(ConstraintViolationException ex) {
		LOGGER.debug("Bad Request!");
        return new ApiErrorResponse(400, 5001, ex.getMessage());
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse NoHandlerFoundException(Exception ex) {
    	LOGGER.debug("Page not found!");
        return new ApiErrorResponse(404, 4041, ex.getMessage());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse unknownException(Exception ex) {
    	LOGGER.debug("Internal Server Error!");
        return new ApiErrorResponse(500, 5002, ex.getMessage());
    }
			
}
