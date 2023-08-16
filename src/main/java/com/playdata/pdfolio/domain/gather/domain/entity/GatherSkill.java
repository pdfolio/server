package com.playdata.pdfolio.domain.gather.domain.entity;

import com.playdata.pdfolio.global.domain.entity.Skill;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class GatherSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Gather gather;
    @Enumerated(EnumType.STRING)
    private Skill skill;
}
