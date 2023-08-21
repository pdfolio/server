package com.playdata.pdfolio.domain.response.oauth2;

import com.playdata.pdfolio.domain.dto.jwt.JwtDto;
import com.playdata.pdfolio.domain.dto.oauth2.UserInfoDto;
import com.playdata.pdfolio.domain.entity.oauth2.Oauth2UserInfo;

public record Oauth2LoginResponse(UserInfoDto user, JwtDto jwtToken) {

    public static Oauth2LoginResponse of(Oauth2UserInfo oauth2UserInfo, JwtDto jwtTokenDto){
        return new Oauth2LoginResponse(
                UserInfoDto.from(oauth2UserInfo),
                jwtTokenDto
        );
    }
}
