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
    private String nickName;
    private String content;
    private List<ReplyDto> gatherReplies;
    public CommentDto(GatherComment gatherComment){
        this.id = gatherComment.getId();
        this.nickName = gatherComment.getMember().getNickName();
        this.content = gatherComment.getContent();
        this.gatherReplies = gatherComment.getReplies() != null?
                gatherComment.getReplies()
                        .stream()
                        .map(ReplyDto::new)
                        .toList()
                :new ArrayList<>();
    }
}
