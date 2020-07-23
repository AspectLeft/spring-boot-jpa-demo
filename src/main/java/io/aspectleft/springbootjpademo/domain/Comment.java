package io.aspectleft.springbootjpademo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@CommentId")
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    private String content;

    @ManyToOne
    private Article article;

    private void clearComment() {
        this.getArticle().getCommentList().removeIf(comment1 -> comment1.getId() == this.getId());
    }
}
