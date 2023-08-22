package com.playdata.pdfolio.domain.entity.member;

import com.playdata.pdfolio.domain.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickName;

    private String provider;

    private String providerId;

    @OneToMany(mappedBy = "member")
    private Set<MemberSkill> skills;

    public static Member getMemberProxy(final Long memberId) {
        return Member.builder()
                .id(memberId)
                .build();
    }
}
