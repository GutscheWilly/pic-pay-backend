package com.gutsche.picpay.application.gateways;

public interface CpfValidatorGateway {
  Boolean validate(String cpf);
  String unformat(String cpf);
}
