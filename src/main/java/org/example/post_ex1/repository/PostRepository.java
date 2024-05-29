package org.example.post_ex1.repository;


import org.example.post_ex1.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<Post> findAll();
    Post findById(int postId);
    void deleteById(int postId);
    void update(Post post);
    Post save(Post post);
}
