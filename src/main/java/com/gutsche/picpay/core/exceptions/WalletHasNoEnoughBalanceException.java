package com.gutsche.picpay.core.exceptions;

public class WalletHasNoEnoughBalanceException extends RuntimeException {
  public WalletHasNoEnoughBalanceException(String message) {
    super(message);
  }
}
