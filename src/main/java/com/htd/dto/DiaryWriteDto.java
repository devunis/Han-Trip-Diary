package com.htd.dto;

import com.htd.model.Diary;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DiaryWriteDto {
    private String title;
    private String content;
    private String picture;

    @Builder
    public DiaryWriteDto(String title, String content, String picture) {
        this.title = title;
        this.content = content;
        this.picture = picture;
    }

    public Diary toDiaryEntity(){
        return Diary.builder()
                .content(content)
                .picture(picture)
                .title(title)
                .build();
    }
}
