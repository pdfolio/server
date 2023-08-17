package com.playdata.pdfolio.domain.entity.project;

import com.playdata.pdfolio.domain.entity.common.Skill;
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
