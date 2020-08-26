package com.htd.dto;

import com.htd.model.Diary;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DiaryShowDto {
    private Long id;
    private String title;
    private String content;
    private String picture;

    @Builder
    public DiaryShowDto(Long id, String title, String content, String picture) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.picture = picture;
    }

    public static DiaryShowDto diaryShowDtoMapper(final Diary diary) {
        return DiaryShowDto.builder()
                .id(diary.getId())
                .content(diary.getContent())
                .picture(diary.getPicture())
                .title(diary.getTitle())
                .build();
    }
}
