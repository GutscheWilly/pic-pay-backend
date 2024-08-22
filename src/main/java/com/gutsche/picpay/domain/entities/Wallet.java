package com.gutsche.picpay.domain.entities;

import com.gutsche.picpay.domain.dtos.CreationWalletDto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "wallets")
public class Wallet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String completeName;

  @Column(unique = true)
  private String cpfOrCnpj;

  @Column(unique = true)
  private String email;

  private String password;

  @ManyToOne
  private WalletType walletType;

  private BigDecimal balance;

  public Wallet(CreationWalletDto creationWalletDto) {
    this.completeName = creationWalletDto.completeName();
    this.cpfOrCnpj = creationWalletDto.cpfOrCnpj();
    this.email = creationWalletDto.email();
    this.password = creationWalletDto.password();
    this.walletType = creationWalletDto.walletTypeEnum().getWalletType();
    this.balance = BigDecimal.ZERO;
  }

  public Wallet() {}

  public Long getId() {
    return id;
  }

  public String getCompleteName() {
    return completeName;
  }

  public String getCpfOrCnpj() {
    return cpfOrCnpj;
  }

  public String getEmail() {
    return email;
  }

  public WalletType getWalletType() {
    return walletType;
  }

  public BigDecimal getBalance() {
    return balance;
  }
}
