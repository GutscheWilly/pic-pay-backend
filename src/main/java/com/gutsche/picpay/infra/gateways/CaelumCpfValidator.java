package com.gutsche.picpay.infra.gateways;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;
import com.gutsche.picpay.application.gateways.CpfValidatorGateway;
import org.springframework.stereotype.Component;

@Component
public class CaelumCpfValidator implements CpfValidatorGateway {
  private final CPFValidator cpfValidator;
  private final CPFFormatter cpfFormatter;

  public CaelumCpfValidator() {
    this.cpfValidator = new CPFValidator();
    this.cpfFormatter = new CPFFormatter();
  }

  public Boolean validate(String cpf) {
    try {
      String unformattedCpf = unformat(cpf);
      cpfValidator.assertValid(unformattedCpf);
      return true;
    } catch (Exception exception) {
      return false;
    }
  }

  public String unformat(String cpf) {
    return cpfFormatter.unformat(cpf);
  }
}
