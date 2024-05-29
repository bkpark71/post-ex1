package org.example.post_ex1.repository;

import org.example.post_ex1.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostMemoryRepository implements PostRepository{
    private Map<Integer, Post> posts = new HashMap<>();
    private int seq = 0;

    public PostMemoryRepository() {
        seq++;
        posts.put(seq, new Post(seq, "test", "test", 0, "user"));
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Post findById(int postId) {
        Post post = posts.get(postId);
        return post;
    }

    @Override
    public void deleteById(int postId) {
        posts.remove(postId);
    }

    @Override
    public void update(Post post) {
        posts.put(post.getPostId(), post);
    }

    @Override
    public Post save(Post post) {
        seq++;
        post.setPostId(seq);
        posts.put(seq, post);
        return post;
    }
}
