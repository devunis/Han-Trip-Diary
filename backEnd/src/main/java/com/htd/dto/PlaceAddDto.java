package com.htd.dto;

import com.htd.model.Place;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PlaceAddDto {
    private Long id;

    private String name;
    private String call;
    private String description;
    private String picture;

    private String tag;

    private String price;

    public PlaceAddDto(Long id, String name, String call, String description, String picture, String tag, String price) {
        this.id = id;
        this.name = name;
        this.call = call;
        this.description = description;
        this.picture = picture;
        this.tag = tag;
        this.price = price;
    }
    public Place toPlaceEntity(){
        return Place.builder()
                .call(call)
                .id(id)
                .description(description)
                .picture(picture)
                .price(price)
                .tag(tag)
                .build();
    }
}
