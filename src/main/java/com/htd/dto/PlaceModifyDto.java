package com.htd.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class PlaceModifyDto {
    private String name;
    private String call;
    private String description;
    private String picture;

    private String tag;
    private String price;

    @Builder
    public PlaceModifyDto(String name, String call, String description, String picture, String tag, String price) {
        this.name = name;
        this.call = call;
        this.description = description;
        this.picture = picture;
        this.tag = tag;
        this.price = price;
    }

}
