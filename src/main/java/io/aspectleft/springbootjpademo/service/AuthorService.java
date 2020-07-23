package io.aspectleft.springbootjpademo.service;

import io.aspectleft.springbootjpademo.domain.Author;
import org.springframework.stereotype.Service;

public interface AuthorService {
    Author updateAuthor();

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    Author findAuthor(long id);

    void deleteAuthor(long id);
}
