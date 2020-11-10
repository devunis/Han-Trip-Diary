package com.webserver.shoppingmall.user.model;

import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reply_id")
    private String title;
    private String content;
    private String author;

    @Builder
    public Reply(String title, String content, String author){
        this.title = title;
        this.author=author;
        this.content = content;
    }
}
