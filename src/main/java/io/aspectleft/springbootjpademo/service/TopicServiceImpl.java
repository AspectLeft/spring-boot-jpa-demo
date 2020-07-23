package io.aspectleft.springbootjpademo.service;

import io.aspectleft.springbootjpademo.domain.Article;
import io.aspectleft.springbootjpademo.domain.ArticleRepository;
import io.aspectleft.springbootjpademo.domain.Topic;
import io.aspectleft.springbootjpademo.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic findTopic(long id) {
        return topicRepository.findById(id).orElse(null);
    }

    @Override
    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    @Transactional
    public Topic includeArticle(long topicId, long articleId) {
        final Topic topic = topicRepository.findById(topicId).orElseThrow(() ->
                new RuntimeException("Topic Not found"));
        final Article article = articleRepository.findById(articleId).orElseThrow(() ->
                new RuntimeException("Article Not found"));
        topic.getArticleList().add(article);


        return topic;
    }

    @Override
    @Transactional
    public Topic unIncludeArticle(long topicId, long articleId) {
        final Topic topic = topicRepository.findById(topicId).orElseThrow(() ->
                new RuntimeException("Topic Not found"));
        final Article article = articleRepository.findById(articleId).orElseThrow(() ->
                new RuntimeException("Article Not found"));
        topic.getArticleList().remove(article);


        return topic;
    }

    @Override
    public void deleteTopic(long id) {
        topicRepository.deleteById(id);
    }
}
