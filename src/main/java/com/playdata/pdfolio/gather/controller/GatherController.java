package com.playdata.pdfolio.gather.controller;

import com.playdata.pdfolio.domain.entity.gather.Gather;
import com.playdata.pdfolio.domain.entity.gather.GatherCategory;
import com.playdata.pdfolio.domain.request.gather.WriteCommentRequest;
import com.playdata.pdfolio.domain.request.gather.WriteReplyRequest;
import com.playdata.pdfolio.domain.request.gather.WriteRequest;
import com.playdata.pdfolio.domain.response.gather.GatherDetailResponse;
import com.playdata.pdfolio.domain.response.gather.GatherResponse;
import com.playdata.pdfolio.gather.service.GatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/{id}")
    public void GatherModify(@PathVariable(name = "id") Long id,
                             @RequestBody WriteRequest writeRequest)
    {
        gatherService.modifyGather(writeRequest, id);
    }
    // 모집글 삭제
    @DeleteMapping("/{id}")
    public void GatherDelete(@PathVariable(name = "id") Long id){
        gatherService.deleteGather(id);
    }
    // 모집글 상세 보기
    @GetMapping("/detail/{id}")
    public GatherDetailResponse detailGather(@PathVariable(name = "id") Long id){
       return gatherService.detailGather(id);
    }

    // 모집글 전체 보기 / 모집글 제목 , 글 내용 , 카테고리 검색
    @GetMapping
    public Page<GatherResponse> allGather(
            @RequestParam(required = false,defaultValue = "0",name = "page")
            Integer page,
            @RequestParam(required = false,defaultValue = "8",name = "size")
            Integer size,
            @RequestParam(required = false,defaultValue = "",name = "keyword")
            String keyword,
            @RequestParam(required = false,defaultValue = "",name = "category")
            GatherCategory category
            ) {
        PageRequest request = PageRequest.of(page, size);
        return gatherService.allGather(request, keyword, category);
    }



// -----------------------------------------------------------------------------
    // 코멘트 작성
    @PostMapping("/comment")
    public void GatherCommentWrite(@RequestBody WriteCommentRequest writeCommentRequest
    ){
        gatherService.writeGatherComment(writeCommentRequest);
    }
    // 코멘트 수정
    @PutMapping("/comment/{id}")
    public void GatherCommentModify(@PathVariable(name = "id") Long id,
                             @RequestBody WriteCommentRequest writeCommentRequest)
    {
        gatherService.modifyGatherComment(writeCommentRequest, id);
    }
    // 코멘트 삭제
    @DeleteMapping("/comment/{id}")
    public void GatherCommentDelete(@PathVariable(name = "id") Long id){
        gatherService.deleteGatherComment(id);
    }
// -----------------------------------------------------------------------------
    // 리플라이 작성
    @PostMapping("/reply")
    public void GatherReplyWrite(@RequestBody WriteReplyRequest writeReplyRequest
    ){
        gatherService.writeGatherReply(writeReplyRequest);
    }

    // 리플라이 수정
    @PutMapping("/reply/{id}")
    public void GatherReplyModify(@PathVariable(name = "id") Long id,
                             @RequestBody WriteReplyRequest writeReplyRequest)
    {
        gatherService.modifyGatherReply(writeReplyRequest, id);
    }
    // 리플라이 삭제
    @DeleteMapping("/reply/{id}")
    public void GatherReplyDelete(@PathVariable(name = "id") Long id){
        gatherService.deleteGatherReply(id);
    }
}
