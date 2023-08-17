package com.playdata.pdfolio.oauth2.service;

import com.playdata.pdfolio.domain.dto.oauth2.AccessTokenDto;
import com.playdata.pdfolio.oauth2.provider.Oauth2Provider;
import com.playdata.pdfolio.oauth2.provider.ProviderFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class Oauth2Service{

    private final ProviderFactory providerFactory;

    public void login(String providerName, String code){
        Oauth2Provider provider = providerFactory.getProvider(providerName);
        AccessTokenDto accessToken = getAccessToken(provider, code);
        System.out.println("accessToken = " + accessToken.token());
    }

    public AccessTokenDto getAccessToken(Oauth2Provider provider, String code){
        return WebClient.create()
                .post()
                .uri(provider.getAccessTokenUrl())
                .headers(header -> {
                    header.setBasicAuth(provider.getClientId(), provider.getClientSecret());
                    header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                    header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    header.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
                })
                .bodyValue(tokenRequest(code, provider))
                .retrieve()
                .bodyToMono(AccessTokenDto.class)
                .block();
    }

    private MultiValueMap<String, String> tokenRequest(String code, Oauth2Provider provider) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("code", code);
        formData.add("grant_type", "authorization_code");
        formData.add("redirect_uri", provider.getRedirectUri());
        return formData;
    }

    public void getUserInfo(Oauth2Provider provider, String code){

    }
}
