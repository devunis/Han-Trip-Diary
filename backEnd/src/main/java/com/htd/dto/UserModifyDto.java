package com.htd.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class UserModifyDto {
    private String pwd;
    private String email;
    private String name;

    @Builder

    public UserModifyDto(String pwd, String email, String name) {
        this.pwd = pwd;
        this.email = email;
        this.name = name;
    }
}
