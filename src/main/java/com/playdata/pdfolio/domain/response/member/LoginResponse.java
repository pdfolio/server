package com.playdata.pdfolio.domain.response.member;

import com.playdata.pdfolio.domain.dto.jwt.JwtDto;

public record LoginResponse(JwtDto jwtTokenDto) {
}
