package com.htd.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uid;
    private String pwd;
    private String email;
    private String name;
    private Role role;

    @Builder
    public User(Long id, String uid, String pwd, String email, String name, Role role) {
        this.id = id;
        this.uid = uid;
        this.pwd = pwd;
        this.email = email;
        this.name = name;
        this.role = role;
    }
}
