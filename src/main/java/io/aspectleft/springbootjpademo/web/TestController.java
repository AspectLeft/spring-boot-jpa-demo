package io.aspectleft.springbootjpademo.web;

import io.aspectleft.springbootjpademo.domain.Author;
import io.aspectleft.springbootjpademo.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class TestController {
    @Autowired
    private AuthorRepository repository;

    @GetMapping
    public Object findAuthorForPage(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
                                    final Pageable pageable) {
        return repository.findAll(pageable);
    }
}
