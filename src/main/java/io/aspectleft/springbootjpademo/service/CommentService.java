package io.aspectleft.springbootjpademo.service;

import io.aspectleft.springbootjpademo.domain.Comment;

public interface CommentService {

    Comment saveComment(Comment comment);

    void deleteComment(long id);
}
