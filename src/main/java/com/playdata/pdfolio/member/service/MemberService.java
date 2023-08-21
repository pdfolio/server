package com.playdata.pdfolio.member.service;

import com.playdata.pdfolio.auth.service.AuthService;
import com.playdata.pdfolio.domain.dto.jwt.JwtDto;
import com.playdata.pdfolio.domain.entity.member.Member;
import com.playdata.pdfolio.domain.request.member.LoginRequest;
import com.playdata.pdfolio.domain.request.member.SignupRequest;
import com.playdata.pdfolio.domain.response.member.LoginResponse;
import com.playdata.pdfolio.member.exception.UnregisteredMemberException;
import com.playdata.pdfolio.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthService authService;

    public LoginResponse login(LoginRequest loginRequest){
        Member member = memberRepository
                .findByProviderIdAndProviderName(
                    loginRequest.providerId(),
                    loginRequest.providerName())
                .orElseThrow(UnregisteredMemberException::new);

        JwtDto jwtTokenDto = authService.createToken(member);
        return new LoginResponse(jwtTokenDto);
    }

    public void signup(SignupRequest signupRequest){
        memberRepository.save(signupRequest.toEntity());
    }

}
