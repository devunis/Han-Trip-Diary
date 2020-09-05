package com.htd.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserLoginDto {
    private String username;
    private String password;

    @Builder
    public UserLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
