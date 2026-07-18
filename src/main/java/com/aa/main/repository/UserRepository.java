package com.aa.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.main.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA auto-generates the query from the method name — no SQL needed
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
