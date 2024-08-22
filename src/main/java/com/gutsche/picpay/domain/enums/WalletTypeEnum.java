package com.gutsche.picpay.domain.enums;

import com.gutsche.picpay.domain.entities.WalletType;

public enum WalletTypeEnum {
  COMMON(1L, "COMMON"),
  STORE(2L, "STORE");

  private final Long id;
  private final String name;

  WalletTypeEnum(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public WalletType getWalletType() {
    return new WalletType(this);
  }
}
