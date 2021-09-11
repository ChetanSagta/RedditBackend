package app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/post/add")
    public void addController(){

    }

    @GetMapping("/post/postId")
    public void getPostById(){

    }

    @GetMapping("/post/getAll")
    public void getAllPosts(){

    }

}
