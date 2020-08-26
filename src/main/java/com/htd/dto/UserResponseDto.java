package com.htd.dto;

import com.htd.model.Diary;

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
    private String uid;
    private String email;
    private String name;
    private String role;
    private List<DiaryShowDto> diaries;

    @Builder
    public UserResponseDto(Long id, String uid, String email, String name, String role, List<DiaryShowDto> diaries) {
        this.id = id;
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.role = role;
        this.diaries = diaries;
    }

    public static UserResponseDto userResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .diaries(user.getDiaries().stream()
                    .map(DiaryShowDto::diaryShowDtoMapper)
                    .collect(Collectors.toList()))
                .role(user.getAuthorities().toString())
                .build();
    }
}
