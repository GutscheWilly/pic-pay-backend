package com.gutsche.picpay.application.controllers.exception_handler;

import com.gutsche.picpay.domain.exceptions.core.PicpayException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

  @ExceptionHandler(PicpayException.class)
  public ProblemDetail handlePicpayException(PicpayException exception) {
    return exception.getProblemDetail();
  }
}
