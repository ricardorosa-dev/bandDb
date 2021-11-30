package dev.ricardorosa.BandDB.exceptions;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DateAdvice {
	
	@ResponseBody
//	@ExceptionHandler({HttpMessageNotReadableException.class})
	@ExceptionHandler({DateTimeParseException.class})
	ResponseEntity<String> WrongDateHandler() {
	    	return new ResponseEntity<String>(
	    			"The date format must be 'dd-MM-yyyy' and the date must be valid.", 
	    			HttpStatus.BAD_REQUEST);
	}

}



