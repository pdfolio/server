package com.playdata.pdfolio.domain.entity.gather;

import com.playdata.pdfolio.domain.entity.common.BaseEntity;
import com.playdata.pdfolio.domain.entity.member.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
public class Gather extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "text")
    private String content;

    private LocalDate startDate;
    private LocalDate closeDate;

    private Long teamSize;

    @Enumerated(EnumType.STRING)
    private GatherCategory category;

    private String contact;
  
    @Builder.Default
    private Long heartCount = 0L;
  
    @Builder.Default
    private Long viewCount = 0L;
  
    @ManyToOne
    private Member member;
  
    @OneToMany(mappedBy = "gather", fetch = FetchType.LAZY)
    private Set<GatherSkill> skills;
  
    @OneToMany(mappedBy = "gather", fetch = FetchType.LAZY)
    private List<GatherComment> comments;

}
