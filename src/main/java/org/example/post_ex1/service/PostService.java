package org.example.post_ex1.service;

import lombok.RequiredArgsConstructor;
import org.example.post_ex1.entity.Post;
import org.example.post_ex1.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findById(id);
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public void updatePost(Post post) {
        postRepository.update(post);
    }

    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }
}
