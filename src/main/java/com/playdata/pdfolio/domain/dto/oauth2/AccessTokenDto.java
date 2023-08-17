package com.playdata.pdfolio.domain.dto.oauth2;

import com.fasterxml.jackson.annotation.JsonProperty;


public record AccessTokenDto(
        @JsonProperty("access_token") String token,
        @JsonProperty("token_type") String type,
        String scope) {
}
