package com.playdata.pdfolio.domain.dto.oauth2;

import com.playdata.pdfolio.domain.entity.oauth2.Oauth2UserInfo;

public record UserInfoDto(String providerName, String userName) {

    public static UserInfoDto from(Oauth2UserInfo oauth2UserInfo){
        return new UserInfoDto(
                oauth2UserInfo.getProviderName(),
                oauth2UserInfo.getUserName()
        );
    }
}
