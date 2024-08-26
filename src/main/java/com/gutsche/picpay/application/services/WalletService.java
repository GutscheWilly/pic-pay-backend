package com.gutsche.picpay.application.services;

import com.gutsche.picpay.application.gateways.*;
import com.gutsche.picpay.application.repositories.WalletRepository;
import com.gutsche.picpay.domain.dtos.CreationWalletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
  private final WalletRepository walletRepository;

  private final CpfValidatorGateway cpfValidatorGateway;
  private final CnpjValidatorGateway cnpjValidatorGateway;
  private final EmailValidatorGateway emailValidatorGateway;
  private final PasswordValidatorGateway passwordValidatorGateway;

  private final CpfFormatterGateway cpfFormatterGateway;
  private final CnpjFormatterGateway cnpjFormatterGateway;

  @Autowired
  public WalletService(
      WalletRepository walletRepository,
      CpfValidatorGateway cpfValidatorGateway,
      CnpjValidatorGateway cnpjValidatorGateway,
      EmailValidatorGateway emailValidatorGateway,
      PasswordValidatorGateway passwordValidatorGateway,
      CpfFormatterGateway cpfFormatterGateway,
      CnpjFormatterGateway cnpjFormatterGateway
  ) {
    this.walletRepository = walletRepository;
    this.cpfValidatorGateway = cpfValidatorGateway;
    this.cnpjValidatorGateway = cnpjValidatorGateway;
    this.emailValidatorGateway = emailValidatorGateway;
    this.passwordValidatorGateway = passwordValidatorGateway;
    this.cpfFormatterGateway = cpfFormatterGateway;
    this.cnpjFormatterGateway = cnpjFormatterGateway;
  }

  public void create(CreationWalletDto creationWalletDto) {

  }
}
