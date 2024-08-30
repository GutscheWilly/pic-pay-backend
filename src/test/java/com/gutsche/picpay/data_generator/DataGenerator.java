package com.gutsche.picpay.data_generator;

public interface DataGenerator {
  String completeName();
  String validCpfCnpj();
  String invalidCpfCnpj();
  String validEmail();
  String invalidEmail();
  String validPassword();
  String invalidPassword();
}
