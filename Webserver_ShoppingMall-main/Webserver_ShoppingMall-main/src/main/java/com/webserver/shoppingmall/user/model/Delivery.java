package com.webserver.shoppingmall.user.model;

import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Delivery extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "delivery_id")
    private int delivery_num;

    @Builder
    public Delivery(int delivery_num){
        this.delivery_num = delivery_num;
    }
}
