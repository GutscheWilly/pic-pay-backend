package com.gutsche.picpay.infra.gateways;

import com.gutsche.picpay.application.gateways.PasswordValidatorGateway;
import org.passay.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PassayPasswordValidator implements PasswordValidatorGateway {
  private final PasswordValidator passwordValidator;

  public PassayPasswordValidator() {
    this.passwordValidator = new PasswordValidator(Arrays.asList(
        new LengthRule(8, 30),
        new CharacterRule(EnglishCharacterData.UpperCase, 1),
        new CharacterRule(EnglishCharacterData.Digit, 1),
        new CharacterRule(EnglishCharacterData.Special, 1),
        new WhitespaceRule()
    ));
  }

  public Boolean validate(String password) {
    return passwordValidator.validate(new PasswordData(password)).isValid();
  }
}
