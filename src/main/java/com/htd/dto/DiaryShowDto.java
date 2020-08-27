package com.htd.dto;

import com.htd.model.Diary;
import com.htd.model.Place;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class DiaryShowDto {
    private Long id;
    private String title;
    private String content;
    private String picture;
    private List<PlaceShowDto> places;

    @Builder
    public DiaryShowDto(Long id, String title, String content, String picture, List<PlaceShowDto> places) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.picture = picture;
        this.places = places;
    }

    public static DiaryShowDto diaryShowDtoMapper(final Diary diary) {
        return DiaryShowDto.builder()
                .id(diary.getId())
                .content(diary.getContent())
                .picture(diary.getPicture())
                .title(diary.getTitle())
                    .places(diary.getPlaces().stream()
                        .map(PlaceShowDto::placeShowDtoMapper)
                            .collect(Collectors.toList()))
                .build();
    }
}
