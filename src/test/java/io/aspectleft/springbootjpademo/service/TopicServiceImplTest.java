package io.aspectleft.springbootjpademo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.aspectleft.springbootjpademo.domain.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TopicServiceImplTest {
    @Autowired
    private TopicService service;

    @Test
    public void saveTopic() {
        final Topic topic = Topic.builder().name("艺术").build();

        service.saveTopic(topic);
    }

    @Test
    public void updateTopic() {
        Topic topic = service.findTopic(27L);
        topic.setName("文学");
        service.updateTopic(topic);
    }

    @Test
    public void includeArticle() {
        service.includeArticle(27L, 18L);
    }

    @Test
    @Transactional
    public void findTopic() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        final Topic topic = service.findTopic(27L);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(topic));
    }

    @Test
    public void unIncludeArticle() {
        service.unIncludeArticle(27L, 18L);
    }

    @Test
    public void deleteTopic() {
        service.deleteTopic(27L);
    }
}