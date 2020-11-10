package com.webserver.shoppingmall.user.model;

import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private String title;
    private String content;
    private String author;

    @Builder
    public Post(String title, String content, String author){
        this.author = author;
        this.content = content;
        this.title = title;
    }
}
