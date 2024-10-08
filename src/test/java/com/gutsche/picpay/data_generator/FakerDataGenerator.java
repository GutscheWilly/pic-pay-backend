package com.gutsche.picpay.data_generator;

import net.datafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class FakerDataGenerator implements DataGenerator {
  private final Faker faker;

  public FakerDataGenerator() {
    this.faker = new Faker();
  }

  public String completeName() {
    return faker.name().fullName();
  }

  public String validCpf() {
    return faker.cpf().valid();
  }

  public String invalidCpf() {
    return faker.cpf().invalid();
  }

  public String validCnpj() {
    return faker.cnpj().valid();
  }

  public String invalidCnpj() {
    return faker.cnpj().invalid();
  }

  public String validEmail() {
    return faker.internet().emailAddress();
  }

  public String invalidEmail() {
    return faker.internet().emailAddress().replace("@", "");
  }

  public String validPassword() {
    return faker.internet().password(8, 30, true, true, true);
  }

  public String invalidPassword() {
    return faker.internet().password(1, 100, false, false, false);
  }
}
