package io.aspectleft.springbootjpademo.service;

import io.aspectleft.springbootjpademo.domain.Author;
import io.aspectleft.springbootjpademo.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository repository;

    @Transactional
    @Override
    public Author updateAuthor() {
        Author author = Author.builder().phone("12233334444").nickName("Mary").signDate(new Date()).build();
        author = repository.save(author);

        author.setPhone("15566667777");

        repository.save(author);

        return author;
    }

    @Override
    public Author saveAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public Author findAuthor(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteAuthor(long id) {
        repository.deleteById(id);
    }
}
