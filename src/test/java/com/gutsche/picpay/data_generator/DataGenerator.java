package com.gutsche.picpay.data_generator;

public interface DataGenerator {
  String completeName();
  String validCpf();
  String invalidCpf();
  String validCnpj();
  String invalidCnpj();
  String validEmail();
  String invalidEmail();
  String validPassword();
  String invalidPassword();
}
