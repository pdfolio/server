package com.playdata.pdfolio.auth.service;

import com.playdata.pdfolio.auth.exception.InvalidTokenException;
import com.playdata.pdfolio.domain.dto.jwt.JwtDto;
import com.playdata.pdfolio.domain.entity.jwt.LoginToken;
import com.playdata.pdfolio.domain.entity.member.Member;
import com.playdata.pdfolio.jwt.repository.LoginTokenRepository;
import com.playdata.pdfolio.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final JwtService jwtService;
    private final LoginTokenRepository loginTokenRepository;

    public JwtDto createToken(Member member){
        JwtDto jwtTokenDto = jwtService.generateToken(member);
        updateRefreshToken(member, jwtTokenDto.refreshToken());
        return jwtTokenDto;
    }

    public void updateRefreshToken(Member member, String refreshToken){
        Optional<LoginToken> loginMember = loginTokenRepository.findByMember(member);

        if(loginMember.isPresent()){
            LoginToken loginToken = loginMember.get();
            loginToken.updateRefreshToken(refreshToken);
        } else {
            LoginToken loginToken = LoginToken.builder()
                    .member(member)
                    .refreshToken(refreshToken)
                    .build();
            loginTokenRepository.save(loginToken);
        }
    }

    public JwtDto renew(String refreshToken) {
        LoginToken loginToken = verifyRefreshToken(refreshToken);
        JwtDto jwtTokenDto = jwtService.generateToken(loginToken.getMember());
        loginToken.updateRefreshToken(jwtTokenDto.refreshToken());
        return jwtTokenDto;
    }

    private LoginToken verifyRefreshToken(String refreshToken){
        return loginTokenRepository
                .findByRefreshToken(refreshToken)
                .orElseThrow(InvalidTokenException::new);
    }

}
