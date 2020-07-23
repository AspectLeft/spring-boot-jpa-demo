package io.aspectleft.springbootjpademo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@ArticleId")
public class Article {
    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "article", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> commentList;

    @ManyToMany(mappedBy = "articleList")
    private List<Topic> topicList;
}
