package com.playdata.pdfolio.auth.controller;

import com.playdata.pdfolio.auth.service.AuthService;
import com.playdata.pdfolio.domain.dto.jwt.JwtDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    @GetMapping("/renew")
    public ResponseEntity<JwtDto> renewToken(
            @CookieValue(value = "refreshToken") Cookie refreshToken,
            HttpServletResponse response)
    {
        JwtDto jwtTokenDto = authService.renew(refreshToken.getValue());
        Cookie cookie = new Cookie("refreshToken", jwtTokenDto.refreshToken());

        cookie.setSecure(true);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        return ResponseEntity.ok().body(jwtTokenDto);
    }
}
