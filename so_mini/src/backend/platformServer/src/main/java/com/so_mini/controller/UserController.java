package com.so_mini.controller;

import com.so_mini.domain.model.Post;
import com.so_mini.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/test", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class UserController {

    //   private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    //    @RequestMapping("/test")
//    public List<User> getUser(){
//        return userRepository.findAll();
//    }
//    @RequestMapping("/test/{u_idx}")
//    public User getUserById(@PathVariable("u_idx") long u_idx){
//        return  userRepository.findById(u_idx).get();
//    }
    @RequestMapping("/test")
    public List<Post> getPost() {
        return postRepository.findAll();
    }
//
//    @RequestMapping("/test/{p_idx}")
//    public Post getUserById(@PathVariable("p_idx") long u_idx) {
//        return postRepository.findById(u_idx).get();
//    }
    @GetMapping("/{p_idx}")
    public Map<String, Object> findById(@PathVariable("p_idx") int id) {
        Map<String, Object> response = new HashMap<>();

        List<Post> oUser = postRepository.findById(id);
        if(!oUser.isEmpty()) {
            response.put("result", "SUCCESS");
        //    response.put("user", oUser.get);
        } else {
            response.put("result", "FAIL");
            response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
        }

        return response;
    }


}
