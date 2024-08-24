package com.gutsche.picpay.infra.gateways;

import com.gutsche.picpay.application.gateways.EmailValidatorGateway;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;

@Component
public class JavaxEmailValidator implements EmailValidatorGateway {
  private final InternetAddress internetAddress;

  public JavaxEmailValidator() {
    this.internetAddress = new InternetAddress();
  }

  public Boolean validate(String email) {
    try {
      internetAddress.setAddress(email);
      internetAddress.validate();
      return true;
    } catch (Exception exception) {
      return false;
    }
  }
}
