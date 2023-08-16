package com.playdata.pdfolio.domain.gather.domain.entity;

import com.playdata.pdfolio.domain.member.domain.entity.Member;
import com.playdata.pdfolio.global.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class GatherReply extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private GatherComment comment;
}
