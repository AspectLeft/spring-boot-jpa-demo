package io.aspectleft.springbootjpademo.service;


import io.aspectleft.springbootjpademo.domain.Article;

public interface ArticleService {
    Article saveArticle(Article article);

    Article updateArticle(Article article);

    Article findArticle(long id);

    void deleteArticle(long id);
}
