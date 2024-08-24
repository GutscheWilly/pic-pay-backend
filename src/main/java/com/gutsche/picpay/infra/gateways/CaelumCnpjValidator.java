package com.gutsche.picpay.infra.gateways;

import br.com.caelum.stella.validation.CNPJValidator;
import com.gutsche.picpay.application.gateways.CnpjValidatorGateway;
import org.springframework.stereotype.Component;

@Component
public class CaelumCnpjValidator implements CnpjValidatorGateway {
  private final CNPJValidator cnpjValidator;

  public CaelumCnpjValidator() {
    this.cnpjValidator = new CNPJValidator();
  }

  public Boolean validate(String cnpj) {
    try {
      cnpjValidator.assertValid(cnpj);
      return true;
    } catch (Exception exception) {
      return false;
    }
  }
}
