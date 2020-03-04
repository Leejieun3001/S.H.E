package com.so_mini.controller;

import com.so_mini.domain.model.Post;
import com.so_mini.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.List;

@RequestMapping(value = "/post", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @GetMapping
    public List<Post> getPosts(){
        return postRepository.findAll();
    }
    @RequestMapping("/{p_idx}")
    public Post getProductById(@PathVariable("p_idx") int id) {
        return postRepository.findById(id).get(0);
    }

}
