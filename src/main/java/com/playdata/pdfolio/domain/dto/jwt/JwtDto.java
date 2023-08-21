package com.playdata.pdfolio.domain.dto.jwt;

import lombok.Builder;

@Builder
public record JwtDto(
        String grantType,
        String accessToken,
        String refreshToken) {
}
