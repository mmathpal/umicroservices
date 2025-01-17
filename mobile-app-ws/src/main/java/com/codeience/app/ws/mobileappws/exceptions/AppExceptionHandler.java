package com.codeience.app.ws.mobileappws.exceptions;

import com.codeience.app.ws.mobileappws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String errorMessageDesc = ex.getLocalizedMessage();

        if(errorMessageDesc == null) errorMessageDesc = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDesc);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        String errorMessageDesc = ex.getLocalizedMessage();

        if(errorMessageDesc == null) errorMessageDesc = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDesc);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
        String errorMessageDesc = ex.getLocalizedMessage();

        if(errorMessageDesc == null) errorMessageDesc = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDesc);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
