package org.luismore.hlvs.repositories;

import org.luismore.hlvs.domain.entities.Token;
import org.luismore.hlvs.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByUserId(Long userId);
    Optional<Token> findByTokenAndUser(String token, User user);
    Optional<Token> findByContent(String content);
}
