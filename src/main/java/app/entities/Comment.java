package app.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Comment {

  int postId;
  int parentCommentId;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int commentId;
  String commentMsg;
  int likes;
  int dislikes;
  @ManyToOne
  @JoinColumn(name = "person_name")
  @CreatedBy
  Person person;
  @CreatedDate
  Date commentedOn;
  Date updatedOn;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Comment comment = (Comment) o;
    return Objects.equals(commentId, comment.commentId);
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
