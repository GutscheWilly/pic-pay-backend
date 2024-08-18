package com.gutsche.picpay.infra.exceptions;

import com.gutsche.picpay.core.exceptions.status.UnauthorizedException;

public class TransferWalletBalanceNotAuthorizedException extends UnauthorizedException {
  public TransferWalletBalanceNotAuthorizedException(String message) {
    super(message);
  }
}
