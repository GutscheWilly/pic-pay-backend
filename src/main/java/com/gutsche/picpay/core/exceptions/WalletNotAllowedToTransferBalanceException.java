package com.gutsche.picpay.core.exceptions;

public class WalletNotAllowedToTransferBalanceException extends RuntimeException {
  public WalletNotAllowedToTransferBalanceException(String message) {
    super(message);
  }
}
