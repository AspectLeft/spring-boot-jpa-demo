package io.aspectleft.springbootjpademo.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository repository;

    @Test
    public void saveAuthorTest() {
        repository.save(Author.builder().nickName("Arvin").phone("198765432").signDate(new Date()).build());
    }

    @Test
    public void findAuthorTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        for (final Author author: repository.findDistinctByNickNameIgnoreCaseAndPhoneOrderBySignDateDesc("Arvin", "198765432")) {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(author));
        }
    }

    @Test
    public void findLikeTest() throws JsonProcessingException  {
        ObjectMapper objectMapper = new ObjectMapper();
        for (final Author author: repository.findByNickNameLike("%Jo%") ) {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(author));
        }
    }

    @Test
    public void findByPhone() throws JsonProcessingException  {
        ObjectMapper objectMapper = new ObjectMapper();
        for (final Author author: repository.findByPhone("8") ) {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(author));
        }
    }

    @Test
    public void setNickName() {
        repository.setNickName("Eric", "198765432");
    }
//
//    @Test
//    public void save() {
//        for (final String name: new String[]{"Alice", "Bob", "Celina"}) {
//            for (final String phone: new String[]{"12345678901", "19876543209", "16543209876"}) {
//                repository.save(Author.builder().nickName(name).phone(phone).signDate(new Date()).build());
//            }
//        }
//    }

    @Test
    public void findAuthorForPageTest() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Page<Author> page = repository.findAll(PageRequest.of(1, 5, sort));
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(page));
    }
}