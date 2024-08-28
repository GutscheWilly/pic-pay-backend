package com.gutsche.picpay.application.controllers.exception_handler;

import com.gutsche.picpay.domain.exceptions.core.PicpayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestControllerExceptionHandler {

  @ExceptionHandler(PicpayException.class)
  public ProblemDetail handlePicpayException(PicpayException exception) {
    return exception.getProblemDetail();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    List<InvalidParam> fieldErrors = exception.getFieldErrors()
        .stream()
        .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
        .toList();

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

    problemDetail.setTitle("Request parameters are not valid.");
    problemDetail.setProperty("invalid-params", fieldErrors);

    return problemDetail;
  }

  private record InvalidParam(
      String name,
      String reason
  ) {}
}
