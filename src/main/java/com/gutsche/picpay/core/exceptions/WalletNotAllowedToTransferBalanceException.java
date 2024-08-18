package com.gutsche.picpay.core.exceptions;

import com.gutsche.picpay.core.exceptions.status.UnauthorizedException;

public class WalletNotAllowedToTransferBalanceException extends UnauthorizedException {
  public WalletNotAllowedToTransferBalanceException(String message) {
    super(message);
  }
}
