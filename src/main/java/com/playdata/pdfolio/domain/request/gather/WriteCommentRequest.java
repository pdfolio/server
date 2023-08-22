package com.playdata.pdfolio.domain.request.gather;

import com.playdata.pdfolio.domain.entity.gather.Gather;
import com.playdata.pdfolio.domain.entity.gather.GatherComment;
import com.playdata.pdfolio.domain.entity.gather.GatherReply;
import com.playdata.pdfolio.domain.entity.member.Member;
import com.playdata.pdfolio.domain.entity.project.Project;
import jakarta.persistence.*;

import java.util.List;

public record WriteCommentRequest(
        Long memberId,
        Long gatherId,
        String content
        ) {
    public GatherComment toEntity(){

        return GatherComment.builder()
                .member(Member.builder().id(memberId).build())
                .gather(Gather.builder().id(gatherId).build())
                .content(content)
                .build();
    }
}
