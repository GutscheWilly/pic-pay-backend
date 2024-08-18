package com.gutsche.picpay.core.exceptions;

import com.gutsche.picpay.core.exceptions.status.BadRequestException;

public class WalletHasNoEnoughBalanceException extends BadRequestException {
  public WalletHasNoEnoughBalanceException(String message) {
    super(message);
  }
}
