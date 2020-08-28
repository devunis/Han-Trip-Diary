package com.htd.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="friend_id")
    private Long id;

    @OneToMany(mappedBy = "friends")
    private List<User> friendList;

    @Builder
    public Friend(Long id, List<User> friendList) {
        this.id = id;
        this.friendList = friendList;
    }
}
