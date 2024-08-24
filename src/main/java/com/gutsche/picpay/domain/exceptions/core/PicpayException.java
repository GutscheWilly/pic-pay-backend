package com.gutsche.picpay.domain.exceptions.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicpayException extends RuntimeException {
  public ProblemDetail getProblemDetail() {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    problemDetail.setTitle("Internal server error.");
    return problemDetail;
  }
}
