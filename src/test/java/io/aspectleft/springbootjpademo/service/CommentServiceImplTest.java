package io.aspectleft.springbootjpademo.service;

import io.aspectleft.springbootjpademo.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceImplTest {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Test
    public void saveComment() {
        commentService.saveComment(Comment.builder().content("Comment content...")
                .article(articleService.findArticle(18L)).build());
    }

    @Test
    public void deleteComment() {
        commentService.deleteComment(24L);
    }
}