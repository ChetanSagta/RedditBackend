package app.service;

import app.entities.Post;
import app.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  @Autowired
  PostRepo postRepo;

  public String returnHello() {
    return "Hello";
  }

  public void savePost(Post post) {
    postRepo.save(post);
  }
}
