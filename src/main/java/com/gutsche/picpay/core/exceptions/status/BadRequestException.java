package com.gutsche.picpay.core.exceptions.status;

import org.springframework.http.HttpStatus;

public class BadRequestException extends StatusException {
  public BadRequestException(String message) {
    super(message, HttpStatus.BAD_REQUEST.value());
  }
}
