package com.webserver.shoppingmall.user.repository;

import com.webserver.shoppingmall.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
