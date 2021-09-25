package app.controller;

import app.entities.Post;
import app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/add")
    public void addPost(Post post){
        postService.savePost(post);
    }

    @GetMapping("/postId")
    public void getPostById(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/getAll")
    public void getAllPosts(){
        throw new UnsupportedOperationException();
    }

}
