package com.gutsche.picpay.application.controllers;

import com.gutsche.picpay.application.dtos.TransferWalletBalanceDto;
import com.gutsche.picpay.application.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
  private final WalletService walletService;

  @Autowired
  public WalletController(WalletService walletService) {
    this.walletService = walletService;
  }

  @PostMapping("/transfer")
  public ResponseEntity<String> transferBalance(@Valid @RequestBody TransferWalletBalanceDto transferWalletBalanceDto) {
    try {
      walletService.transferBalance(
          transferWalletBalanceDto.amount(),
          transferWalletBalanceDto.fromWalletId(),
          transferWalletBalanceDto.toWalletId()
      );

      return ResponseEntity.ok("Transfer successful.");
    } catch (Exception exception) {
      return ResponseEntity.badRequest().body(exception.getMessage());
    }
  }
}
