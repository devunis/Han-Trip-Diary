package com.htd.dto;

import com.htd.model.Friend;
import com.htd.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class FriendShowDto {
    private Long id;
    private String name;
    private String email;

    @Builder
    public FriendShowDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static List<FriendShowDto> friendShowDtoMapper(final Friend friend){
        return friend.getFriendList().stream()
                .map(x->FriendShowDto.builder()
                    .id(x.getId())
                    .email(x.getEmail())
                    .name(x.getName())
                    .build())
                .collect(Collectors.toList());
    }
}
