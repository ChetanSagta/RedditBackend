package app.entities;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
@RequiredArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int postId;
  private int likes;
  private int dislikes;
  private String postedBy;
  private Date postedDate;
  private String title;
  @Lob
  private MultipartFile[] image;
  private String description;
  private String subredditName;
}
