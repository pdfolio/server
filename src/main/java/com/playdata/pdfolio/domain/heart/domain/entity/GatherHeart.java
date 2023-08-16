package com.playdata.pdfolio.domain.heart.domain.entity;

import com.playdata.pdfolio.domain.gather.domain.entity.Gather;
import com.playdata.pdfolio.domain.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class GatherHeart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Gather gather;
}
