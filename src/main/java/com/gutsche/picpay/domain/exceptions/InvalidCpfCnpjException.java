package com.gutsche.picpay.domain.exceptions;

import com.gutsche.picpay.domain.exceptions.core.PicpayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InvalidCpfCnpjException extends PicpayException {
  private final String cpfCnpj;

  public InvalidCpfCnpjException(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  @Override
  public ProblemDetail getProblemDetail() {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Invalid CPF/CNPJ.");
    problemDetail.setDetail(cpfCnpj + " is invalid.");
    return problemDetail;
  }
}
