package com.htd.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserLoginDto {
    private String username;
    private String pwd;

    @Builder
    public UserLoginDto(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
}
