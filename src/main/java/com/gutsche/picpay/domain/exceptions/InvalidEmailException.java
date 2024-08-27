package com.gutsche.picpay.domain.exceptions;

import com.gutsche.picpay.domain.exceptions.core.PicpayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InvalidEmailException extends PicpayException {
  private final String email;

  public InvalidEmailException(String email) {
    this.email = email;
  }

  @Override
  public ProblemDetail getProblemDetail() {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Invalid email.");
    problemDetail.setDetail(email + " is invalid.");
    return problemDetail;
  }
}
