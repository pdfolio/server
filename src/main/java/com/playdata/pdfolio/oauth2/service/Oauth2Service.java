package com.playdata.pdfolio.oauth2.service;

import com.playdata.pdfolio.domain.dto.jwt.JwtTokenDto;
import com.playdata.pdfolio.domain.entity.member.Member;
import com.playdata.pdfolio.domain.entity.oauth2.Oauth2AccessToken;
import com.playdata.pdfolio.domain.entity.oauth2.Oauth2UserInfo;
import com.playdata.pdfolio.domain.response.oauth2.Oauth2LoginResponse;
import com.playdata.pdfolio.jwt.service.JwtService;
import com.playdata.pdfolio.member.repository.MemberRepository;
import com.playdata.pdfolio.oauth2.provider.Oauth2Provider;
import com.playdata.pdfolio.oauth2.provider.ProviderFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class Oauth2Service {

    private final ProviderFactory providerFactory;
    private final JwtService jwtService;
    private final MemberRepository memberRepository;

    public Oauth2LoginResponse login(String providerName, String code) {
        Oauth2Provider provider = providerFactory.getProvider(providerName);
        Oauth2AccessToken accessToken = getAccessToken(provider, code);
        Oauth2UserInfo userInfo = getUserInfo(provider, accessToken);

        Member member = memberRepository
                .findByProviderIdAndProviderName(
                        userInfo.getProviderId(),
                        userInfo.getProviderName())
                .orElseGet(() ->
                        memberRepository.save(Member.builder()
                                .name(userInfo.getUserName())
                                .nickName(userInfo.getUserName())
                                .providerId(userInfo.getProviderId())
                                .providerName(userInfo.getProviderName())
                                .imageUrl(userInfo.getImageUrl())
                                .build()));

        JwtTokenDto jwtTokenDto = jwtService.generateToken(member);

        return Oauth2LoginResponse.of(userInfo, jwtTokenDto);
    }

    private Oauth2AccessToken getAccessToken(Oauth2Provider provider, String code) {
        return WebClient.create()
                .post()
                .uri(provider.getAccessTokenUri())
                .headers(header -> {
                    header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                    header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    header.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
                })
                .bodyValue(tokenRequest(code, provider))
                .retrieve()
                .bodyToMono(Oauth2AccessToken.class)
                .block();
    }

    private Oauth2UserInfo getUserInfo(Oauth2Provider provider, Oauth2AccessToken tokenDto) {
        Map<String, Object> attributes = WebClient.create()
                .get()
                .uri(provider.getUserInfoUri())
                .headers(header -> header.setBearerAuth(tokenDto.token()))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {
                })
                .block();

        return Oauth2UserInfo.of(provider.getName(), attributes);
    }

    private MultiValueMap<String, String> tokenRequest(String code, Oauth2Provider provider) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("code", code);
        formData.add("client_id", provider.getClientId());
        formData.add("client_secret", provider.getClientSecret());
        formData.add("grant_type", "authorization_code");
        formData.add("redirect_uri", provider.getRedirectUri());
        return formData;
    }
}
