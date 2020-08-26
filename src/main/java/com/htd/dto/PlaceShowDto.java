package com.htd.dto;

import com.htd.model.Place;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PlaceShowDto {
    private Long id;

    private String name;
    private String call;
    private String description;
    private String picture;

    private String tag;

    private String price;


    @Builder

    public PlaceShowDto(Long id, String name, String call, String description, String picture, String tag, String price) {
        this.id = id;
        this.name = name;
        this.call = call;
        this.description = description;
        this.picture = picture;
        this.tag = tag;
        this.price = price;
    }

    public static PlaceShowDto placeShowDtoMapper(final Place place) {
        return PlaceShowDto.builder()
                .id(place.getId())
                .call(place.getCall())
                .description(place.getDescription())
                .picture(place.getPicture())
                .name(place.getName())
                .picture(place.getPicture())
                .tag(place.getTag())
                .price(place.getPrice())
                .build();
    }
}