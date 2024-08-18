package com.gutsche.picpay.core.cases;

import java.math.BigDecimal;

public interface TransferWalletBalanceUseCase {
  void transferBalance(BigDecimal amount, Long fromWalletId, Long toWalletId);
}
