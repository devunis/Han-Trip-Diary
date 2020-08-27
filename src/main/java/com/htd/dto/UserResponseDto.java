package com.htd.dto;

import com.htd.model.Diary;

import com.htd.model.Friend;
import com.htd.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String role;
    private List<DiaryShowDto> diaries;
    private List<FriendShowDto> friends;

    @Builder
    public UserResponseDto(Long id, String username, String email, String name, String role, List<DiaryShowDto> diaries, List<FriendShowDto> friends) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.role = role;
        this.diaries = diaries;
        this.friends = friends;
    }

    public static UserResponseDto userResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .diaries(user.getDiaries().stream()
                    .map(DiaryShowDto::diaryShowDtoMapper)
                    .collect(Collectors.toList()))
                .friends(user.getFriends().getFriendList()
                    .stream().map(FriendShowDto::friendShowDtoMapper)
                    .collect(Collectors.toList()))
                .role(user.getAuthorities().toString())
                .build();
    }
}
