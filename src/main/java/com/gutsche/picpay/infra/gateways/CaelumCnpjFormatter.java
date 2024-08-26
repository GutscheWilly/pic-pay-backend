package com.gutsche.picpay.infra.gateways;

import br.com.caelum.stella.format.CNPJFormatter;
import com.gutsche.picpay.application.gateways.CnpjFormatterGateway;
import org.springframework.stereotype.Component;

@Component
public class CaelumCnpjFormatter implements CnpjFormatterGateway {
  private final CNPJFormatter cnpjFormatter;

  public CaelumCnpjFormatter() {
    this.cnpjFormatter = new CNPJFormatter();
  }

  public String unformat(String cnpj) {
    return cnpjFormatter.unformat(cnpj);
  }
}
