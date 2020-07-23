package io.aspectleft.springbootjpademo.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WalletRepositoryTest {
    @Autowired
    WalletRepository repository;

    @Test
    void findWalletTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Wallet wallet = repository.findById(17L).get();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(wallet));
    }


}