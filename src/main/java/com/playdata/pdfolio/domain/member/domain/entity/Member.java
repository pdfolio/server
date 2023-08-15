package com.playdata.pdfolio.domain.member.domain.entity;

import com.playdata.pdfolio.global.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickName;
    private String provider;
    private String providerId;
    @OneToMany(mappedBy = "member")
    private Set<MemberSkill> skills;
}
