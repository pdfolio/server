package com.playdata.pdfolio.member.controller;

import com.playdata.pdfolio.auth.UserInfo;
import com.playdata.pdfolio.domain.entity.member.Member;
import com.playdata.pdfolio.domain.request.member.UpdateRequest;
import com.playdata.pdfolio.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public Member test(@AuthenticationPrincipal UserInfo userInfo){
        return userInfo.getMember();
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void updateBasic(@RequestBody UpdateRequest updateRequest){
        Long id = 1L;
        memberService.updateBasic(id, updateRequest);
    }

    @PutMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateContainSkills(@RequestBody UpdateRequest updateRequest){
        Long id = 1L;
        memberService.updateContainSkills(id, updateRequest);
    }

}
