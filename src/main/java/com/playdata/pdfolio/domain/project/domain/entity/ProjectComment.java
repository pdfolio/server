package com.playdata.pdfolio.domain.project.domain.entity;

import com.playdata.pdfolio.domain.member.domain.entity.Member;
import com.playdata.pdfolio.global.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class ProjectComment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Member member;
    @OneToMany(mappedBy = "comment")
    private List<ProjectReply> replies;
}
