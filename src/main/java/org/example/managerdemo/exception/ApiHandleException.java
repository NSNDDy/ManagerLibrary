package org.example.managerdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiHandleException {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorMessage> handleAppException(AppException e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(e.getMsg());
        errorMessage.setCode(400);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
