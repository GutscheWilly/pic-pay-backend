package com.gutsche.picpay.application.services;

import com.gutsche.picpay.application.entities.Wallet;
import com.gutsche.picpay.application.repositories.WalletRepository;
import com.gutsche.picpay.core.cases.TransferWalletBalanceUseCase;
import com.gutsche.picpay.core.exceptions.WalletNotFoundException;
import com.gutsche.picpay.infra.apis.TransferWalletBalanceAuthenticator;
import com.gutsche.picpay.infra.exceptions.TransferWalletBalanceNotAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class WalletService implements TransferWalletBalanceUseCase {
  private final WalletRepository walletRepository;
  private final TransferWalletBalanceAuthenticator transferWalletBalanceAuthenticator;

  @Autowired
  public WalletService(WalletRepository walletRepository, TransferWalletBalanceAuthenticator transferWalletBalanceAuthenticator) {
    this.walletRepository = walletRepository;
    this.transferWalletBalanceAuthenticator = transferWalletBalanceAuthenticator;
  }

  @Transactional
  public void transferBalance(BigDecimal amount, Long fromWalletId, Long toWalletId) {
    Wallet fromWallet = this.walletRepository.findById(fromWalletId)
        .orElseThrow(() -> new WalletNotFoundException("From wallet not found."));

    Wallet toWallet = this.walletRepository.findById(toWalletId)
        .orElseThrow(() -> new WalletNotFoundException("To wallet not found."));

    fromWallet.verifyTransferConditions(amount);

    try {
      this.transferWalletBalanceAuthenticator.authorize();
    } catch (Exception exception) {
      throw new TransferWalletBalanceNotAuthorizedException("Transfer wallet balance not authorized.");
    }

    fromWallet.withdrawBalance(amount);
    toWallet.addBalance(amount);

    walletRepository.save(fromWallet);
    walletRepository.save(toWallet);

    this.transferWalletBalanceAuthenticator.notifyWallets();
  }
}
