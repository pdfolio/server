package com.playdata.pdfolio.jwt.service;

import com.playdata.pdfolio.domain.dto.jwt.JwtTokenDto;
import com.playdata.pdfolio.domain.entity.member.Member;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET_KEY;
    private final SignatureAlgorithm HS256 = SignatureAlgorithm.HS256;
    private final long ACCESS_TOKEN_VALID_TIME = 3 * 60 * 60 * 1000L; // 3시간
    private final long REFRESH_TOKEN_VALID_TIME = 3 * 24 * 60 * 60 * 1000L; // 3일

    public JwtTokenDto generateToken(Member member){

        final SecretKeySpec KEY = new SecretKeySpec(SECRET_KEY.getBytes(), HS256.getJcaName());
        long now = System.currentTimeMillis();

        String accessToken = Jwts.builder()
                .claim("id", member.getId())
                .claim("nickName", member.getNickName())
                .setExpiration(new Date(now + ACCESS_TOKEN_VALID_TIME))
                .signWith(KEY)
                .compact();

        String refreshToken = Jwts.builder()
                .claim("id", member.getId())
                .setExpiration(new Date(now + REFRESH_TOKEN_VALID_TIME))
                .signWith(KEY)
                .compact();

        return JwtTokenDto.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

}
