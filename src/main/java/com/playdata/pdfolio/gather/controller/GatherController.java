package com.playdata.pdfolio.gather.controller;

import com.playdata.pdfolio.domain.request.gather.WriteRequest;
import com.playdata.pdfolio.gather.service.GatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gathers")
public class GatherController {
    private final GatherService gatherService;

    // 모집글 작성
    @PostMapping
    public void write(@RequestBody WriteRequest writeRequest){
        gatherService.writeGather(writeRequest);
    }
    // 모집글 수정
    @PutMapping
    public void moify(@RequestBody WriteRequest writeRequest){
        gatherService.modifyGather(writeRequest);
    }

}
