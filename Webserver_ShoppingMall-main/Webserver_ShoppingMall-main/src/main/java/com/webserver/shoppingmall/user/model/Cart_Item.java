package com.webserver.shoppingmall.user.model;

import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Cart_Item<item> extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private int orderPrice;
    private int count;
    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart cart;
    @OneToMany(mappedBy="cart_id")
    private List<item> itemList = new ArrayList<item>();

    @Builder
    public Cart_Item(int orderPrice, int count){
        this.count = count;
        this.orderPrice = orderPrice;
    }
}
