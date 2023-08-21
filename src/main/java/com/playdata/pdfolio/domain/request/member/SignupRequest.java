package com.playdata.pdfolio.domain.request.member;

import com.playdata.pdfolio.domain.entity.member.Member;

import java.util.List;
import java.util.stream.Collectors;

public record SignupRequest(
        String name,
        String nickName,
        String providerId,
        String providerName,
        String imageUrl,
        List<String> skills)
{
    public Member toEntity(){
        return Member.builder()
                .name(name)
                .nickName(nickName)
                .providerId(providerId)
                .providerName(providerName)
                .imageUrl(imageUrl)
                .build();
    }
}
