package com.playdata.pdfolio.domain.entity.project;

import com.playdata.pdfolio.domain.entity.common.BaseEntity;
import com.playdata.pdfolio.domain.entity.member.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Project extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    @ManyToOne
    private Member member;
    private String repositoryUrl;
    private String publishUrl;
    private Long likeCount;
    private Long viewCount;
    @OneToMany(mappedBy = "project")
    private Set<ProjectSkill> skills;
}
