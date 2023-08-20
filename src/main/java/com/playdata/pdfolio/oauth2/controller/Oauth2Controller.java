package com.playdata.pdfolio.oauth2.controller;

import com.playdata.pdfolio.domain.response.oauth2.Oauth2LoginResponse;
import com.playdata.pdfolio.oauth2.service.Oauth2Service;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/oauth2")
@RequiredArgsConstructor
public class Oauth2Controller {

    private final Oauth2Service oauth2Service;

    @GetMapping("/{provider}")
    public ResponseEntity<Oauth2LoginResponse> login(
            @PathVariable("provider") String provider,
            @RequestParam("code") String code,
            HttpServletResponse response)
    {
        Oauth2LoginResponse loginResponse = oauth2Service.login(provider, code);
        Cookie cookie = new Cookie("refreshToken", loginResponse.jwtToken().refreshToken());
        cookie.setSecure(true);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        return ResponseEntity.ok().body(loginResponse);
    }

}
