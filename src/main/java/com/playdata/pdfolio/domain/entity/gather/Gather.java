package com.playdata.pdfolio.domain.entity.gather;

import com.playdata.pdfolio.domain.entity.common.BaseEntity;
import com.playdata.pdfolio.domain.entity.member.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@DynamicUpdate
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

    @Builder.Default
    private Integer heartCount = 0;

    @Builder.Default
    private Integer viewCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "gather")
    private Set<GatherSkill> skills;

    public void increaseHeartCount() {
        this.heartCount++;
    }

    public void decreaseHeartCount() {
        this.heartCount--;
    }
}
