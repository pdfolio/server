package com.playdata.pdfolio.oauth2.controller;

import com.playdata.pdfolio.oauth2.service.Oauth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/oauth2")
@RequiredArgsConstructor
public class Oauth2Controller {

    private final Oauth2Service oauth2Service;

    @GetMapping("/{provider}")
    public void login(
            @PathVariable("provider") String provider,
            @RequestParam("code") String code)
    {
        oauth2Service.login(provider, code);
    }
}
