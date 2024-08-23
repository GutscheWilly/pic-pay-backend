package com.gutsche.picpay.config;

import com.gutsche.picpay.application.repositories.WalletTypeRepository;
import com.gutsche.picpay.domain.enums.WalletTypeEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DatabaseLoader {
  private final WalletTypeRepository walletTypeRepository;

  public DatabaseLoader(WalletTypeRepository walletTypeRepository) {
    this.walletTypeRepository = walletTypeRepository;
  }

  @Bean
  CommandLineRunner initDatabase() {
    return args -> Arrays.stream(WalletTypeEnum.values()).forEach(walletTypeEnum ->
        walletTypeRepository.save(walletTypeEnum.getWalletType())
    );
  }
}
