package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecipeException.class)
	public ResponseEntity<MyErrorDetail> BookExceptionHandler(RecipeException be, WebRequest req) {
		
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage(be.getMessage());
		errorDetail.setDetail(req.getDescription(false));
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetail> UserExceptionHandler(UserException be, WebRequest req) {
		
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage(be.getMessage());
		errorDetail.setDetail(req.getDescription(false));
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RatingException.class)
	public ResponseEntity<MyErrorDetail> RatingExceptionHandler(UserException be, WebRequest req) {
		
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage(be.getMessage());
		errorDetail.setDetail(req.getDescription(false));
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
		
	}
	

	@ExceptionHandler(BookmarkException.class)
	public ResponseEntity<MyErrorDetail> BookmarkExceptionHandler(UserException be, WebRequest req) {
		
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage(be.getMessage());
		errorDetail.setDetail(req.getDescription(false));
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> ValidationExceptionHandler(MethodArgumentNotValidException mve) {
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage("Validation error");
		errorDetail.setDetail(mve.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetail> NoHandlerException(NoHandlerFoundException nfe, WebRequest req) {

    	MyErrorDetail myErorDetail = new MyErrorDetail();
    	
    	myErorDetail.setTimeStamp(LocalDateTime.now());
    	myErorDetail.setMessage(nfe.getMessage());
    	myErorDetail.setDetail(req.getDescription(false));
    	
    	return new ResponseEntity<>(myErorDetail, HttpStatus.BAD_REQUEST);
    	
    	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> AllOtherExceptionHandler(Exception e, WebRequest req) {
		MyErrorDetail errorDetail = new MyErrorDetail();
		errorDetail.setTimeStamp(LocalDateTime.now());
		errorDetail.setMessage(e.getMessage());
		errorDetail.setDetail(req.getDescription(false));
		
		return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
