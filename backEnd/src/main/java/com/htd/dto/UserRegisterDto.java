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
    private String username;
    private String password;
    private String email;
    private String name;

    @Builder
    public UserRegisterDto(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public User toUserEntity(){
        return User.builder()
                .email(email)
                .name(name)
                .password(password)
                .username(username)
                .build();
    }


}
