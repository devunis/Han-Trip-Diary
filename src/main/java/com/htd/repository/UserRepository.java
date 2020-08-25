package com.htd.repository;

import com.htd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUidOrEmail(String uid, String email);
}
