package com.gutsche.picpay.infra.gateways;

import com.gutsche.picpay.application.gateways.PasswordEncryptorGateway;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityPasswordEncryptor implements PasswordEncryptorGateway {
  private final PasswordEncoder passwordEncoder;

  public SpringSecurityPasswordEncryptor() {
    this.passwordEncoder = new BCryptPasswordEncoder();
  }

  public String encrypt(String password) {
    return passwordEncoder.encode(password);
  }
}
