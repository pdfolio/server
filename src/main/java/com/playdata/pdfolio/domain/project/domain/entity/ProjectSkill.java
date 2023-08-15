package com.playdata.pdfolio.domain.project.domain.entity;

import com.playdata.pdfolio.global.domain.entity.Skill;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class ProjectSkill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Project project;
    @Enumerated(EnumType.STRING)
    private Skill skill;
}
