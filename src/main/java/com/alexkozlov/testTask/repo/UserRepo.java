package com.alexkozlov.testTask.repo;

import com.alexkozlov.testTask.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findById(long id);

    Optional<Users> findByEmail(String email);
}
