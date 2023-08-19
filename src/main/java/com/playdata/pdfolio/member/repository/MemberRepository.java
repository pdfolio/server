package com.playdata.pdfolio.member.repository;

import com.playdata.pdfolio.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByProviderIdAndProviderName(String id, String name);
}
