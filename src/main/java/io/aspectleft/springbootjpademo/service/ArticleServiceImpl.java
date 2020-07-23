package io.aspectleft.springbootjpademo.service;

import io.aspectleft.springbootjpademo.domain.Article;
import io.aspectleft.springbootjpademo.domain.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository repository;

    @Override
    public Article saveArticle(Article article) {
        return repository.save(article);
    }

    @Override
    public Article updateArticle(Article article) {
        return repository.save(article);
    }

    @Override
    public Article findArticle(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteArticle(long id) {
        repository.deleteById(id);
    }
}
