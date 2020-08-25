package com.htd.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserLoginDto {
    private String uid;
    private String pwd;

    @Builder
    public UserLoginDto(String uid, String pwd) {
        this.uid = uid;
        this.pwd = pwd;
    }
}
