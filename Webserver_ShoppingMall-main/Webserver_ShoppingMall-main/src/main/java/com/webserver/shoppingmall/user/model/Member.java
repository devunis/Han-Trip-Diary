package com.webserver.shoppingmall.user.model;

import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
   private Long id;
   private String name;
   private String pw;
   private String role;

    @ManyToOne
    @JoinColumn(name ="order_id")
    private Order order;
    @Builder
    public Member(Long id, String name, String pw, String role){
       this.id = id;
       this.name = name;
       this.pw = pw;
       this.role = role;
   }


}
