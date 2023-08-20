package com.playdata.pdfolio.jwt.repository;

import com.playdata.pdfolio.domain.entity.jwt.LoginToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginTokenRepository extends JpaRepository<LoginToken, Long> {

    Optional<LoginToken> findByRefreshToken(String refreshToken);
}
