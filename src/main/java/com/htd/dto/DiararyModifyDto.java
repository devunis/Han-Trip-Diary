package com.htd.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class DiararyModifyDto {
    private String title;
    private String content;
    private String picture;

    @Builder
    public DiararyModifyDto(String title, String content, String picture) {
        this.title = title;
        this.content = content;
        this.picture = picture;
    }
}
