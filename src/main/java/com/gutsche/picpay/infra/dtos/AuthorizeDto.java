package com.gutsche.picpay.infra.dtos;

public record AuthorizeDto(
    String status,
    AuthorizationData data
) {}
