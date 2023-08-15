package com.playdata.pdfolio.domain.heart.domain.entity;

import com.playdata.pdfolio.domain.member.domain.entity.Member;
import com.playdata.pdfolio.domain.project.domain.entity.Project;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class ProjectHeart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Project project;
}
