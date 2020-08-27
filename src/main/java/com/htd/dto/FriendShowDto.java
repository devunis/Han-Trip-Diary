package com.htd.dto;

import com.htd.model.Friend;
import com.htd.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class FriendShowDto {
    private String name;
    private String email;


    @Builder
    public FriendShowDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public static FriendShowDto friendShowDtoMapper(final User user){
        return FriendShowDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
