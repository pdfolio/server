package com.playdata.pdfolio.domain.response.oauth2;

import com.playdata.pdfolio.domain.dto.jwt.JwtTokenDto;
import com.playdata.pdfolio.domain.dto.oauth2.UserInfoDto;
import com.playdata.pdfolio.domain.entity.oauth2.Oauth2UserInfo;

public record Oauth2Response(UserInfoDto user, JwtTokenDto jwtToken) {

    public static Oauth2Response of(Oauth2UserInfo oauth2UserInfo, JwtTokenDto jwtTokenDto){
        return new Oauth2Response(
                UserInfoDto.from(oauth2UserInfo),
                jwtTokenDto
        );
    }
}
