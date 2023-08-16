package com.playdata.pdfolio.domain.gather.domain.entity;

import com.playdata.pdfolio.global.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Gather extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime closeDate;
    private Long teamSize;
    @Enumerated(EnumType.STRING)
    private GatherCategory category;
    private String contact;
    private Long likeCount;
    private Long viewCount;
    @OneToMany(mappedBy = "gather")
    private Set<GatherSkill> skills;
}
