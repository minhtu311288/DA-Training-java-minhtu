package com.example.demo.controller;

import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.demo.exception.ApiErrorResponse;
import com.example.demo.exception.LocationNotFoundException;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.exception.ResponseMsg;
import com.example.demo.utils.LogUtil;

@RestControllerAdvice
public class BaseController {
	
	//product not found
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseMsg  handleIOException(ProductNotFoundException ex){
		
		ResponseMsg  ResponseMsg = new ResponseMsg(ex.getMessage());
		
		LogUtil.error(this.getClass(),"Product not found!");
		
		return ResponseMsg;
	}
	
	//location not found
	@ExceptionHandler(LocationNotFoundException.class)
	public ResponseMsg  handleIOException(LocationNotFoundException ex){
		
		ResponseMsg  ResponseMsg = new ResponseMsg(ex.getMessage());
		
		LogUtil.error(this.getClass(),"Location not found!");
		
		return ResponseMsg;
	}
	
	@ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse constraintViolationException(ConstraintViolationException ex) {
		
		LogUtil.error(this.getClass(),"Bad Request!");
		
        return new ApiErrorResponse(400, 5001, ex.getMessage());
        
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse NoHandlerFoundException(Exception ex) {
    	
    	LogUtil.error(this.getClass(),"Page not found!");
    	
        return new ApiErrorResponse(404, 4041, ex.getMessage());
        
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse unknownException(Exception ex) {
    	
    	LogUtil.error(this.getClass(),"Internal Server Error!");
    	
        return new ApiErrorResponse(500, 5002, ex.getMessage());
        
    }
    
}
