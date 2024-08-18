package com.gutsche.picpay.core.exceptions;

import com.gutsche.picpay.core.exceptions.status.NotFoundException;

public class WalletNotFoundException extends NotFoundException {
  public WalletNotFoundException(String message) {
    super(message);
  }
}
