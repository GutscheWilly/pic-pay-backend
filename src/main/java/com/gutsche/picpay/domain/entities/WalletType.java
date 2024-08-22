package com.gutsche.picpay.domain.entities;

import com.gutsche.picpay.domain.enums.WalletTypeEnum;
import jakarta.persistence.*;

@Entity(name = "wallet_types")
public class WalletType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

  public WalletType(WalletTypeEnum walletTypeEnum) {
    this.id = walletTypeEnum.getId();
    this.name = walletTypeEnum.getName();
  }

  public WalletType() {}

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
