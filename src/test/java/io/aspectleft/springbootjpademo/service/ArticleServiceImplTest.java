package io.aspectleft.springbootjpademo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.aspectleft.springbootjpademo.domain.Article;
import io.aspectleft.springbootjpademo.domain.Comment;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceImplTest {
    @Autowired
    private ArticleService service;

    @Test
    public void saveArticle() {
        final Article article = Article.builder().title("This is a title").content("This is content")
                .build();
        article.setCommentList(Arrays.asList(Comment.builder().article(article).content("comment content 1").build(),
                Comment.builder().article(article).content("comment content 2").build()));

        service.saveArticle(article);
    }


    @Test
    public void updateArticle() {
        Article article = service.findArticle(21L);
        article.setContent("Updated content");
        service.updateArticle(article);
    }

    @Test
    @Transactional
    public void findArticle() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Article article = service.findArticle(18L);
        for (final Comment comment: article.getCommentList()) {
            System.out.println(comment.getContent());
        }
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(article));
    }

    @Test
    public void deleteArticle() {
        service.deleteArticle(21L);
    }
}