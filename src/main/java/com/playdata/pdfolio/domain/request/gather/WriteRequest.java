package com.playdata.pdfolio.domain.request.gather;

import com.playdata.pdfolio.domain.entity.gather.Gather;
import com.playdata.pdfolio.domain.entity.gather.GatherCategory;
import com.playdata.pdfolio.domain.entity.member.Member;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record WriteRequest(
        Long MemberId,
        String title,
        String content,
        LocalDate startDate,
        LocalDate closeDate,
        Long teamSize,
        @Enumerated(EnumType.STRING) GatherCategory category,
        String contact,
        List<String> gatherSkill
) {
    public Gather toEntity(){
        return Gather.builder()
                .member(Member.builder().id(MemberId).build())
                .title(title)
                .content(content)
                .teamSize(teamSize)
                .startDate(startDate)
                .closeDate(closeDate)
                .category(category)
                .contact(contact)
                .build();
    }
}