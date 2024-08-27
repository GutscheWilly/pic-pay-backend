package com.gutsche.picpay.application.services;

import com.gutsche.picpay.application.gateways.*;
import com.gutsche.picpay.application.repositories.WalletRepository;
import com.gutsche.picpay.domain.dtos.CreationWalletDto;
import com.gutsche.picpay.domain.exceptions.InvalidCpfCnpjException;
import com.gutsche.picpay.domain.exceptions.InvalidEmailException;
import com.gutsche.picpay.domain.exceptions.WalletAlreadyRegisteredException;
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
    String unformattedCpfCnpj = validateAndUnformatCpfCnpj(creationWalletDto.cpfCnpj());

    validateEmail(creationWalletDto.email());

    validateWalletRegistration(unformattedCpfCnpj, creationWalletDto.email());


  }

  private String validateAndUnformatCpfCnpj(String cpfCnpj) {
    if (cpfValidatorGateway.validate(cpfCnpj)) {
      return cpfFormatterGateway.unformat(cpfCnpj);
    }

    if (cnpjValidatorGateway.validate(cpfCnpj)) {
      return cnpjFormatterGateway.unformat(cpfCnpj);
    }

    throw new InvalidCpfCnpjException(cpfCnpj);
  }

  private void validateEmail(String email) {
    if (emailValidatorGateway.validate(email)) {
      return;
    }

    throw new InvalidEmailException(email);
  }

  private void validateWalletRegistration(String cpfCnpj, String email) {
    if (walletRepository.findByCpfCnpjOrEmail(cpfCnpj, email).isPresent()) {
      throw new WalletAlreadyRegisteredException();
    }
  }
}
