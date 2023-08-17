package com.playdata.pdfolio.oauth2.provider;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GithubProvider implements Oauth2Provider{

    @Value("${oauth2.user.github.client-id}")
    private String clientId;
    @Value("${oauth2.user.github.client-secret}")
    private String clientSecret;
    @Value("${oauth2.user.github.redirect-uri}")
    private String redirectUri;
    @Value("${oauth2.user.github.access-token-uri}")
    private String accessTokenUrl;
}
