package com.gutsche.picpay.application.gateways;

public interface PasswordEncryptorGateway {
  String encrypt(String password);
  Boolean compare(String password, String encryptedPassword);
}
