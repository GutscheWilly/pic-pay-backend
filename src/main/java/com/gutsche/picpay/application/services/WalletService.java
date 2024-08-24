package com.gutsche.picpay.application.services;

import com.gutsche.picpay.application.gateways.CnpjValidatorGateway;
import com.gutsche.picpay.application.gateways.CpfValidatorGateway;
import com.gutsche.picpay.application.gateways.EmailValidatorGateway;
import com.gutsche.picpay.application.gateways.PasswordValidatorGateway;
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

  @Autowired
  public WalletService(
      WalletRepository walletRepository,
      CpfValidatorGateway cpfValidatorGateway,
      CnpjValidatorGateway cnpjValidatorGateway,
      EmailValidatorGateway emailValidatorGateway,
      PasswordValidatorGateway passwordValidatorGateway
  ) {
    this.walletRepository = walletRepository;
    this.cpfValidatorGateway = cpfValidatorGateway;
    this.cnpjValidatorGateway = cnpjValidatorGateway;
    this.emailValidatorGateway = emailValidatorGateway;
    this.passwordValidatorGateway = passwordValidatorGateway;
  }

  public void create(CreationWalletDto creationWalletDto) {

  }
}
