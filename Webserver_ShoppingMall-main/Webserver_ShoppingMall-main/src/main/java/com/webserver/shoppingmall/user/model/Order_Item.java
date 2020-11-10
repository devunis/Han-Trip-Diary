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
public class Order_Item<item_id, order_id> extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_item_id")
    private String order_id;
    private String item_id;
    private int orderPrice;
    @OneToMany(mappedBy="order_item_id")
    private List<item_id> item_idList = new ArrayList<item_id>();

    @OneToMany(mappedBy="order_item_id")
    private List<order_id> order_idList = new ArrayList<order_id>();

    @Builder
    public Order_Item(String order_id, String item_id, int orderPrice){
        this.order_id = order_id;
        this.item_id = item_id;
        this.orderPrice = orderPrice;
    }
}
