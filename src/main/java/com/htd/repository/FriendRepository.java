package com.htd.repository;

import com.htd.model.Friend;
import com.htd.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
