package com.gutsche.picpay.domain.exceptions;

import com.gutsche.picpay.domain.exceptions.core.PicpayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletAlreadyRegisteredException extends PicpayException {
  @Override
  public ProblemDetail getProblemDetail() {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
    problemDetail.setTitle("Wallet already registered.");
    problemDetail.setDetail("CPF/CNPJ or email are already being used.");
    return problemDetail;
  }
}
