package com.rafael.falconi.Api.repositories;

import com.rafael.falconi.Api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByEmail(String email);
}
