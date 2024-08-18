package com.gutsche.picpay.core.exceptions.status;

import org.springframework.http.HttpStatus;

public class NotFoundException extends StatusException {
  public NotFoundException(String message) {
    super(message, HttpStatus.NOT_FOUND.value());
  }
}
