package com.gutsche.picpay.core.exceptions.status;

public abstract class StatusException extends RuntimeException {
  private final Integer status;

  public StatusException(String message, Integer status) {
    super(message);
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }
}
