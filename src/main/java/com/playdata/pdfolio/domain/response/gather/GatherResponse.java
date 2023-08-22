package com.playdata.pdfolio.domain.response.gather;

import com.playdata.pdfolio.domain.dto.gather.CommentDto;
import com.playdata.pdfolio.domain.entity.gather.Gather;
import com.playdata.pdfolio.domain.entity.gather.GatherCategory;
import com.playdata.pdfolio.domain.entity.gather.GatherSkill;
import com.playdata.pdfolio.domain.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
//제목, 기술스택, host 유저, 모집인원, 시작날짜, 마감날짜
public class GatherResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDate startDate;
    private LocalDate closeDate;
    private Long teamSize;
    private GatherCategory category;
    private String contact;
    private Long heartCount;
    private Long viewCount;
    private Boolean isDeleted;

    private Member member;

    private Set<GatherSkill> skills;


    public GatherResponse(Gather gather) {
        this.id = gather.getId();
        this.title = gather.getTitle();
        this.content = gather.getContent();
        this.startDate = gather.getStartDate();
        this.closeDate = gather.getCloseDate();
        this.teamSize = gather.getTeamSize();
        this.category = gather.getCategory();
        this.contact = gather.getContact();
        this.heartCount = gather.getHeartCount();
        this.viewCount = gather.getViewCount();
        this.member = gather.getMember();

    }


}
