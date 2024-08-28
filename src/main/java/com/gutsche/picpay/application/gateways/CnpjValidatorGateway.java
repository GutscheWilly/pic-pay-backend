package com.gutsche.picpay.application.gateways;

public interface CnpjValidatorGateway {
  Boolean validate(String cnpj);
  String unformat(String cnpj);
}
