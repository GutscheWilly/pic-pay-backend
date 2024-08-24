package com.gutsche.picpay.infra.gateways;

import br.com.caelum.stella.validation.CPFValidator;
import com.gutsche.picpay.application.gateways.CpfValidatorGateway;
import org.springframework.stereotype.Component;

@Component
public class CaelumCpfValidator implements CpfValidatorGateway {
  private final CPFValidator cpfValidator;

  public CaelumCpfValidator() {
    this.cpfValidator = new CPFValidator();
  }

  public Boolean validate(String cpf) {
    try {
      cpfValidator.assertValid(cpf);
      return true;
    } catch (Exception exception) {
      return false;
    }
  }
}
