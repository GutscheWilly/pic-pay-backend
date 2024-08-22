package com.gutsche.picpay.domain.dtos;

import com.gutsche.picpay.domain.enums.WalletTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreationWalletDto(

  @NotBlank(message = "Complete name required.")
  String completeName,

  @NotBlank(message = "CPF or CNPJ required.")
  String cpfOrCnpj,

  @NotBlank(message = "Email required.")
  String email,

  @NotBlank(message = "Password required.")
  String password,

  @NotNull(message = "Wallet type required.")
  WalletTypeEnum walletTypeEnum

) {}
