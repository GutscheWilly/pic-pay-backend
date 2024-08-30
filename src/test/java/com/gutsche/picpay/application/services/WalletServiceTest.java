package com.gutsche.picpay.application.services;

import com.gutsche.picpay.application.gateways.CnpjValidatorGateway;
import com.gutsche.picpay.application.gateways.CpfValidatorGateway;
import com.gutsche.picpay.application.gateways.PasswordEncryptorGateway;
import com.gutsche.picpay.application.repositories.WalletRepository;
import com.gutsche.picpay.domain.dtos.CreationWalletDto;
import com.gutsche.picpay.domain.entities.Wallet;
import com.gutsche.picpay.domain.enums.WalletTypeEnum;
import com.gutsche.picpay.data_generator.DataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class WalletServiceTest {
  private final WalletService walletService;
  private final WalletRepository walletRepository;
  private final CpfValidatorGateway cpfValidatorGateway;
  private final CnpjValidatorGateway cnpjValidatorGateway;
  private final PasswordEncryptorGateway passwordEncryptorGateway;
  private final DataGenerator dataGenerator;

  @Autowired
  public WalletServiceTest(
      WalletService walletService,
      WalletRepository walletRepository,
      CpfValidatorGateway cpfValidatorGateway,
      CnpjValidatorGateway cnpjValidatorGateway,
      PasswordEncryptorGateway passwordEncryptorGateway,
      DataGenerator dataGenerator
  ) {
    this.walletService = walletService;
    this.walletRepository = walletRepository;
    this.cpfValidatorGateway = cpfValidatorGateway;
    this.cnpjValidatorGateway = cnpjValidatorGateway;
    this.passwordEncryptorGateway = passwordEncryptorGateway;
    this.dataGenerator = dataGenerator;
  }

  @Test
  public void createWalletSuccessful() {
    CreationWalletDto dto = new CreationWalletDto(
        dataGenerator.completeName(),
        dataGenerator.validCpfCnpj(),
        dataGenerator.validEmail(),
        dataGenerator.validPassword(),
        WalletTypeEnum.COMMON
    );

    walletService.create(dto);

    Optional<Wallet> walletOptional = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
    assertTrue(walletOptional.isPresent());

    Wallet createdWallet = walletOptional.get();
    assertEquals(createdWallet.getCompleteName(), dto.completeName());
    assertTrue(createdWallet.getCpfCnpj().equals(cpfValidatorGateway.unformat(dto.cpfCnpj())) || createdWallet.getCpfCnpj().equals(cnpjValidatorGateway.unformat(dto.cpfCnpj())));
    assertEquals(createdWallet.getEmail(), dto.email());
    assertTrue(passwordEncryptorGateway.compare(dto.password(), createdWallet.getEncryptedPassword()));
    assertEquals(createdWallet.getWalletType().getId(), dto.walletTypeEnum().getWalletType().getId());
  }
}
