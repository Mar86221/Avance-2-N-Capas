package org.luismore.hlvs.repositories;

import org.luismore.hlvs.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}
