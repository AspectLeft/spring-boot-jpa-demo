package io.aspectleft.springbootjpademo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@TopicId")
public class Topic {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "topic_article_list",
            joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private List<Article> articleList;
}
