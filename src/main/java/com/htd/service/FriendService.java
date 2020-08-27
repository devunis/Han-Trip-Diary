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

        User user1 = userRepository.findById(follow1).orElseThrow(()-> new RuntimeException("no friend"));
        User user2 = userRepository.findById(follow2).orElseThrow(()-> new RuntimeException("no friend"));
        if (user1.getFriends() == null){
            Friend friend = friendRepository.save(
                    Friend.builder()
                    .friendList(new ArrayList<>())
                    .build()
            );
            user1.setFriends(friend);
        }
        Friend friend = user1.getFriends();
        user1.getFriends().getFriendList().add(user2);
        user1.setFriends(friend);
        user1.getFriends().getFriendList().stream().forEach(x->log.info(x.getId().toString()));
        return user1.getId();
    }
}
