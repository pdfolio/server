package com.playdata.pdfolio.domain.gather.domain;

import com.playdata.pdfolio.domain.member.domain.entity.Member;
import com.playdata.pdfolio.domain.project.domain.entity.Project;
import com.playdata.pdfolio.global.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class GatherComment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Member member;
    @OneToMany(mappedBy = "comment")
    private List<GatherReply> replies;
}
