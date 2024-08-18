package com.gutsche.picpay.infra.apis;

import com.gutsche.picpay.infra.dtos.AuthorizeDto;
import com.gutsche.picpay.infra.dtos.NotifyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "transferWalletBalanceAuthenticator", url = "https://util.devi.tools/api")
public interface TransferWalletBalanceAuthenticator {

  @GetMapping("/v2/authorize")
  AuthorizeDto authorize();

  @PostMapping("/v1/notify")
  @Retryable(retryFor = Exception.class, maxAttempts = 10, backoff = @Backoff(delay = 1000))
  NotifyDto notifyWallets();
}
