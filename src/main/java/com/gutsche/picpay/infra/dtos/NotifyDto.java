package com.gutsche.picpay.infra.dtos;

public record NotifyDto(
   String status,
   MessageData message
) {}
