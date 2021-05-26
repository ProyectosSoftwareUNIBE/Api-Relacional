package com.rafael.falconi.Api.repositories;

import com.rafael.falconi.Api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
