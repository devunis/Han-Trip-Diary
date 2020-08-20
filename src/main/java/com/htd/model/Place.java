package com.htd.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String call;
    private String description;
    private String picture;

    private String tag;

    private String price;

    @ManyToOne
    private Memory memory;

    public Place(Long id, String name, String call, String description, String picture, String tag, String price, Memory memory) {
        this.id = id;
        this.name = name;
        this.call = call;
        this.description = description;
        this.picture = picture;
        this.tag = tag;
        this.price = price;
        this.memory = memory;
    }
}
