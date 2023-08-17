package com.playdata.pdfolio.oauth2.provider;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Getter
@Component
public class GoogleProvider implements Oauth2Provider {

    @Value("${oauth2.user.github.client-id}")
    private String clientId;
    @Value("${oauth2.user.github.client-secret}")
    private String clientSecret;
    @Value("${oauth2.user.github.redirect-uri}")
    private String redirectUri;
    @Value("${oauth2.user.github.access-token-uri}")
    private String accessTokenUrl;
}
