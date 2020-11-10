package com.webserver.shoppingmall.user.model;

import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item")
    private String name;
    private int price;
    private int stockquantity;
    private String category;
}
