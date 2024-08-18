package com.gutsche.picpay.core.exceptions.status;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends StatusException {
  public UnauthorizedException(String message) {
    super(message, HttpStatus.UNAUTHORIZED.value());
  }
}
