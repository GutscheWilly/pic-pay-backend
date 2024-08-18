package com.gutsche.picpay.application.entities;

import com.gutsche.picpay.core.dtos.CreateWalletDto;
import com.gutsche.picpay.core.enums.WalletType;
import com.gutsche.picpay.core.exceptions.WalletHasNoEnoughBalanceException;
import com.gutsche.picpay.core.exceptions.WalletNotAllowedToTransferBalanceException;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "wallets")
public class Wallet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String completeName;

  @Column(unique = true)
  private String cpf_cnpj;

  @Column(unique = true)
  private String email;

  private String password;

  private WalletType walletType;

  private BigDecimal balance;

  public Wallet() {}

  public Wallet(CreateWalletDto createWalletDto) {
    this.completeName = createWalletDto.completeName();
    this.cpf_cnpj = createWalletDto.cpf_cnpj();
    this.email = createWalletDto.email();
    this.password = createWalletDto.password();
    this.walletType = createWalletDto.walletType();
    this.balance = BigDecimal.ZERO;
  }

  public Long getId() {
    return id;
  }

  public String getCompleteName() {
    return completeName;
  }

  public String getCpf_cnpj() {
    return cpf_cnpj;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public WalletType getWalletType() {
    return walletType;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public Boolean isCommonType() {
    return this.walletType == WalletType.COMMON;
  }

  public Boolean hasBalanceEqualOrGreaterThan(BigDecimal amount) {
    return this.balance.compareTo(amount) >= 0;
  }

  public void addBalance(BigDecimal amount) {
    this.balance = this.balance.add(amount);
  }

  public void withdrawBalance(BigDecimal amount) {
    this.balance = this.balance.subtract(amount);
  }

  public void verifyTransferConditions(BigDecimal amount) {
    if (!this.isCommonType()) {
      throw new WalletNotAllowedToTransferBalanceException("Wallet not allowed to transfer balance because it is not common type.");
    }

    if (!this.hasBalanceEqualOrGreaterThan(amount)) {
      throw new WalletHasNoEnoughBalanceException("Wallet has no enough balance.");
    }
  }
}
