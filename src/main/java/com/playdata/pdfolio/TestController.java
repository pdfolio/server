package com.playdata.pdfolio;

import com.playdata.pdfolio.global.domain.entity.Skill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public Skill[] aa(){
        return Skill.values();
    }
}
