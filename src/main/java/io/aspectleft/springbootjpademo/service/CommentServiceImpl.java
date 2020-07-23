package io.aspectleft.springbootjpademo.service;

import io.aspectleft.springbootjpademo.domain.Comment;
import io.aspectleft.springbootjpademo.domain.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository repository;

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        return repository.save(comment);
    }

    @Transactional
    @Override
    public void deleteComment(long id) {
        // repository.deleteBy(id);

        Comment comment = repository.findById(id).orElse(null);
        repository.deleteById(id);
    }

}
