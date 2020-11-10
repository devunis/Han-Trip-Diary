package com.webserver.shoppingmall.user.model;

import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="Member")
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @OneToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;
    @OneToOne
    @JoinColumn(name="member_id")
    private Member member;


    private String order_date;

    @Builder
    public Order(String order_date){
        this.order_date = order_date;
    }
}
