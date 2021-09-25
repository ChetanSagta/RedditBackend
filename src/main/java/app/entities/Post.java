package app.entities;

import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@RequiredArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int postId;
  int likes;
  int dislikes;
  String postedBy;
  Date postedDate;
  String title;
  byte[] image;
  String description;
  String subredditName;
}
