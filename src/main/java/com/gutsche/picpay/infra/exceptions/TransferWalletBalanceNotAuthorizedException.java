package com.gutsche.picpay.infra.exceptions;

public class TransferWalletBalanceNotAuthorizedException extends RuntimeException {
  public TransferWalletBalanceNotAuthorizedException(String message) {
    super(message);
  }
}
