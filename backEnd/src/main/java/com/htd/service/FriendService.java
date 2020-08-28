package com.htd.service;

import com.htd.model.Friend;
import com.htd.model.User;
import com.htd.repository.FriendRepository;
import com.htd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@Service
public class FriendService {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    @Transactional
    public Object addFriend(Long follow1, Long follow2) {

        User user1 = userRepository.findById(follow1)
                .orElseThrow(()-> new RuntimeException("no friend"));

        Friend friend = friendRepository.findById(user1.getFriends().getId())
                .orElseThrow(() -> new RuntimeException("friend not found"));

        friend.getFriendList().add(userRepository.findById(follow2)
                .orElseThrow(()-> new RuntimeException("no friend")));

        user1.setFriends(friend);

        return friend.getId();
    }
}
