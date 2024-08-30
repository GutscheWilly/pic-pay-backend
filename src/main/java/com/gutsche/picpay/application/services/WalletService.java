package com.gutsche.picpay.application.services;

import com.gutsche.picpay.application.gateways.*;
import com.gutsche.picpay.application.repositories.WalletRepository;
import com.gutsche.picpay.domain.dtos.CreationWalletDto;
import com.gutsche.picpay.domain.entities.Wallet;
import com.gutsche.picpay.domain.exceptions.InvalidCpfCnpjException;
import com.gutsche.picpay.domain.exceptions.InvalidEmailException;
import com.gutsche.picpay.domain.exceptions.InvalidPasswordException;
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
  private final PasswordEncryptorGateway passwordEncryptorGateway;

  @Autowired
  public WalletService(
      WalletRepository walletRepository,
      CpfValidatorGateway cpfValidatorGateway,
      CnpjValidatorGateway cnpjValidatorGateway,
      EmailValidatorGateway emailValidatorGateway,
      PasswordValidatorGateway passwordValidatorGateway,
      PasswordEncryptorGateway passwordEncryptorGateway
  ) {
    this.walletRepository = walletRepository;
    this.cpfValidatorGateway = cpfValidatorGateway;
    this.cnpjValidatorGateway = cnpjValidatorGateway;
    this.emailValidatorGateway = emailValidatorGateway;
    this.passwordValidatorGateway = passwordValidatorGateway;
    this.passwordEncryptorGateway = passwordEncryptorGateway;
  }

  public void create(CreationWalletDto dto) {
    validateCpfCnpj(dto.cpfCnpj());
    validateEmail(dto.email());

    String unformattedCpfCnpj = unformatCpfCnpj(dto.cpfCnpj());
    validateWalletRegistration(unformattedCpfCnpj, dto.email());

    validatePassword(dto.password());
    String encryptedPassword = passwordEncryptorGateway.encrypt(dto.password());

    walletRepository.save(new Wallet(
        new CreationWalletDto(
            dto.completeName(),
            unformattedCpfCnpj,
            dto.email(),
            encryptedPassword,
            dto.walletTypeEnum()
        )
    ));
  }

  private void validateCpfCnpj(String cpfCnpj) {
    if (cpfValidatorGateway.validate(cpfCnpj) || cnpjValidatorGateway.validate(cpfCnpj)) {
      return;
    }

    throw new InvalidCpfCnpjException(cpfCnpj);
  }

  private void validateEmail(String email) {
    if (emailValidatorGateway.validate(email)) {
      return;
    }

    throw new InvalidEmailException(email);
  }

  private String unformatCpfCnpj(String cpfCnpj) {
    if (cpfValidatorGateway.validate(cpfCnpj)) {
      return cpfValidatorGateway.unformat(cpfCnpj);
    }

    return cnpjValidatorGateway.unformat(cpfCnpj);
  }

  private void validateWalletRegistration(String cpfCnpj, String email) {
    if (walletRepository.findByCpfCnpjOrEmail(cpfCnpj, email).isPresent()) {
      throw new WalletAlreadyRegisteredException();
    }
  }

  private void validatePassword(String password) {
    if (passwordValidatorGateway.validate(password)) {
      return;
    }

    throw new InvalidPasswordException();
  }
}
