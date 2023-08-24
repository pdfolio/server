package com.playdata.pdfolio.domain.dto.gather;

import com.playdata.pdfolio.domain.entity.gather.GatherComment;
import com.playdata.pdfolio.domain.entity.gather.GatherReply;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReplyDto {
    private Long id;
    private String nickName;
    private String content;
    public ReplyDto(GatherReply gatherReply){
        this.id = gatherReply.getId();
        this.nickName = gatherReply.getMember().getNickName();
        this.content = gatherReply.getContent();
    }
}
