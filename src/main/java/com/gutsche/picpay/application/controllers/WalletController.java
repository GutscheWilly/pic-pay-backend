package com.gutsche.picpay.application.controllers;

import com.gutsche.picpay.application.services.WalletService;
import com.gutsche.picpay.domain.dtos.CreationWalletDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody @Valid CreationWalletDto creationWalletDto) {
    walletService.create(creationWalletDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
