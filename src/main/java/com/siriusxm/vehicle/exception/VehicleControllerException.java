package com.siriusxm.vehicle.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class VehicleControllerException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), BAD_REQUEST.value(), "Validation Failed", ex.getBindingResult().toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Invalid", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VehicleException.class)
    public final ResponseEntity<ErrorDetails> globalApplicationExcpetionHandler(VehicleException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getCode(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), 500, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGloException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), 500, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, INTERNAL_SERVER_ERROR);
    }
}
