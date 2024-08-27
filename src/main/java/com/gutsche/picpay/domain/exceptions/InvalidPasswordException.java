package com.gutsche.picpay.domain.exceptions;

import com.gutsche.picpay.domain.exceptions.core.PicpayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InvalidPasswordException extends PicpayException {
  @Override
  public ProblemDetail getProblemDetail() {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Invalid password.");
    problemDetail.setDetail(
        "Password have must contain: " +
        "# 8 - 30 characters " +
        "# 1 upper case character " +
        "# 1 digit " +
        "# 1 special character " +
        "# No white space."
    );
    return problemDetail;
  }
}
