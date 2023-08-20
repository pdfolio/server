package com.playdata.pdfolio.domain.dto.jwt;

import lombok.Builder;

@Builder
public record JwtTokenDto(String grantType, String accessToken, String refreshToken) {
}
