package app.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int postId;
  private int likes;
  private int dislikes;
  @ManyToOne
  @JoinColumn(name = "person_name")
  @CreatedBy
  private Person postedBy;
  @CreatedDate
  private Date postedDate;
  private String title;
  @Lob
  private MultipartFile[] image;
  private String description;
  private String subredditName;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Post post = (Post) o;
    return Objects.equals(postId, post.postId);
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
