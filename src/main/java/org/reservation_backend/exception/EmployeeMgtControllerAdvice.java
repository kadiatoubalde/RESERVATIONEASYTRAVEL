package org.reservation_backend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class EmployeeMgtControllerAdvice {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = ResourceAlreadyExistException.class)
    ErrorResponse handleResourceAlreadyExistException(ResourceAlreadyExistException ex) {
        log.error("=====> {}",ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("=====> {}",ex.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getFieldError().getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = AccountException.class)
    ErrorResponse handleAccountException(AccountException ex) {
        log.error("=====> {}",ex.getMessage());
        return new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = UsernameNotFoundException.class)
    ErrorResponse handleUsernameNotFoundException(UsernameNotFoundException ex) {
        log.error("=====> {}",ex.getMessage());
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ResourceException.class)
    ErrorResponse handleResourceException(ResourceException ex) {
        log.error("=====> {}",ex.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }


}
