package com.gutsche.picpay.core.dtos;

import com.gutsche.picpay.core.enums.WalletType;

public record CreateWalletDto(
    String completeName,
    String cpf_cnpj,
    String email,
    String password,
    WalletType walletType
) {}
