package com.playdata.pdfolio.gather.controller;

import com.playdata.pdfolio.domain.request.gather.WriteRequest;
import com.playdata.pdfolio.gather.service.GatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gathers")
public class GatherController {
    private final GatherService gatherService;

    // 모집글 작성
    @PostMapping
    public void GatherWrite(@RequestBody WriteRequest writeRequest){
        gatherService.writeGather(writeRequest);
    }
    // 모집글 수정
    @PutMapping
    public void GatherMoify(@RequestBody WriteRequest writeRequest){
        gatherService.modifyGather(writeRequest);
    }
    // 모집글 삭제
    @DeleteMapping("/{id}")
    public void GatherDelete(@PathVariable(name = "id") Long id){
        gatherService.deleteGather(id);
    }

}
