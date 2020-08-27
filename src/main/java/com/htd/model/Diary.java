package com.htd.model;

import com.htd.model.auditing.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Getter @Setter
@Entity
public class Diary extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String picture;

    @Enumerated(EnumType.STRING)
    private Scope scope;

    @OneToMany(mappedBy = "memory")
    private List<Place> places;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    @Builder
    public Diary(Long id, String title, String content, Scope scope, String picture, User writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.scope = scope;
        this.picture = picture;
        this.writer = writer;
    }

    public Diary addDiaryToUser(User user) {
        this.writer = user;
        user.getDiaries().add(this);
        return this;
    }
}
