package com.gutsche.picpay.infra.gateways;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.validation.CNPJValidator;
import com.gutsche.picpay.application.gateways.CnpjValidatorGateway;
import org.springframework.stereotype.Component;

@Component
public class CaelumCnpjValidator implements CnpjValidatorGateway {
  private final CNPJValidator cnpjValidator;
  private final CNPJFormatter cnpjFormatter;

  public CaelumCnpjValidator() {
    this.cnpjValidator = new CNPJValidator();
    this.cnpjFormatter = new CNPJFormatter();
  }

  public Boolean validate(String cnpj) {
    try {
      String unformattedCnpj = unformat(cnpj);
      cnpjValidator.assertValid(unformattedCnpj);
      return true;
    } catch (Exception exception) {
      return false;
    }
  }

  public String unformat(String cnpj) {
    return cnpjFormatter.unformat(cnpj);
  }
}
