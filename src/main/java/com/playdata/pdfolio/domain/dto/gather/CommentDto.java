package com.playdata.pdfolio.domain.dto.gather;

import com.playdata.pdfolio.domain.entity.gather.GatherComment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private String content;
    private List<ReplyDto> gatherReplies;
    public CommentDto(GatherComment gatherComment){
        this.id = gatherComment.getId();
        this.content = gatherComment.getContent();

        this.gatherReplies = gatherComment.getReplies() != null?
                gatherComment.getReplies()
                        .stream()
                        .map(gatherReply -> new ReplyDto(gatherReply))
                        .toList()
                :new ArrayList<>();
    }
}
