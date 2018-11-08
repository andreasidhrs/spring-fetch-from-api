package com.example.api.controller;

import com.example.api.domain.Post;
import com.example.api.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiTest {
    @GetMapping("/users")
    public User[] getusers() {
        final String uri = "http://jsonplaceholder.typicode.com/users";

        RestTemplate restTemplate = new RestTemplate();
        User[] result = restTemplate.getForObject(uri, User[].class);

        for(User u : result) {
            System.out.format("Found User: %s%n", u.getUsername());
        }

        return result;
    }

    @GetMapping("/posts")
    public Post[] getposts() {
        final String uri = "http://jsonplaceholder.typicode.com/posts";

        RestTemplate restTemplate = new RestTemplate();
        Post[] result = restTemplate.getForObject(uri, Post[].class);

        for(Post p : result) {
            System.out.format("Found post: %s%n", p.getTitle());
        }

        return result;
    }

    @GetMapping("/posts/{postid}")
    public Post getpostbyid(@PathVariable int postid) {
        final String uri = "http://jsonplaceholder.typicode.com/posts/{postid}";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> params = new HashMap<>();
        params.put("postid", postid);

        Post result = restTemplate.getForObject(uri, Post.class, params);

        System.out.format("Found post: %s%n", result.getTitle());

        return result;
    }
}
