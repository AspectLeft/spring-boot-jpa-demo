package io.aspectleft.springbootjpademo.service;

import io.aspectleft.springbootjpademo.domain.Topic;

public interface TopicService {

    Topic saveTopic(Topic topic);

    Topic findTopic(long id);

    Topic updateTopic(Topic topic);

    Topic includeArticle(long topicId, long articleId);

    Topic unIncludeArticle(long topicId, long articleId);

    void deleteTopic(long id);
}
