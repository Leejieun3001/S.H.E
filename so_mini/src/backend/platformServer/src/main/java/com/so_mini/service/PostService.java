package com.so_mini.service;

import com.so_mini.domain.model.Post;
import com.so_mini.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;

    }
    public List<Post> findById(int id) {
        return postRepository.findById(id);
    }
}
