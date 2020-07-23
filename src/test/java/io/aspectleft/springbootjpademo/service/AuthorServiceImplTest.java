package io.aspectleft.springbootjpademo.service;

import io.aspectleft.springbootjpademo.domain.Author;
import io.aspectleft.springbootjpademo.domain.Wallet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorServiceImplTest {

    @Autowired
    AuthorService service;

    @Test
    void updateAuthor() {
        final Author author = service.findAuthor(14);
        author.getWallet().setBalance(BigDecimal.valueOf(988.88));
        service.updateAuthor(author);
    }

    @Test
    void saveAuthorWithWallet() {
        service.saveAuthor(Author.builder().nickName("Rich").signDate(new Date()).phone("18888888888")
                .wallet(Wallet.builder().balance(BigDecimal.valueOf(888.88)).build())
                .build());
    }

    @Test
    void deleteAuthorTest() {
        service.deleteAuthor(14);
    }
}