package com.htd.dto;

import com.htd.model.Role;
import com.htd.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class UserRegisterDto {
    private String uid;
    private String pwd;
    private String email;
    private String name;

    @Builder
    public UserRegisterDto(String uid, String pwd, String email, String name) {
        this.uid = uid;
        this.pwd = pwd;
        this.email = email;
        this.name = name;
    }

    public User toUserEntity(){
        return User.builder()
                .email(email)
                .name(name)
                .pwd(pwd)
                .uid(uid)
                .role(Role.USER)
                .build();
    }


}
