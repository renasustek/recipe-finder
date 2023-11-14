package com.github.group37.roadmap.advice;

import com.github.group37.roadmap.errors.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class UserExceptionHandler {

  @ResponseBody
  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String userNotFoundHandler(UserNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(TransactionSystemException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String transactionSystemException(TransactionSystemException ex) {
    return "Name or password either too long or short.";
  }
}