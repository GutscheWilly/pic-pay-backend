package com.gutsche.picpay.infra.gateways;

import br.com.caelum.stella.format.CPFFormatter;
import com.gutsche.picpay.application.gateways.CpfFormatterGateway;
import org.springframework.stereotype.Component;

@Component
public class CaelumCpfFormatter implements CpfFormatterGateway {
  private final CPFFormatter cpfFormatter;

  public CaelumCpfFormatter() {
    this.cpfFormatter = new CPFFormatter();
  }

  public String unformat(String cpf) {
    return cpfFormatter.unformat(cpf);
  }
}
