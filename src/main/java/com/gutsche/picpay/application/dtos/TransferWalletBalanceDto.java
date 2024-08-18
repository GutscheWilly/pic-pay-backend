package com.gutsche.picpay.application.dtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferWalletBalanceDto(
    @NotNull(message = "Amount cannot be null")
    BigDecimal amount,

    @NotNull(message = "From wallet id cannot be null")
    Long fromWalletId,

    @NotNull(message = "To wallet id cannot be null")
    Long toWalletId
) {}
