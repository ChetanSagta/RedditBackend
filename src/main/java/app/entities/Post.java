package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int postId;
  int likes;
  int dislikes;
  String postedBy;
  Date postedDate;
  String title;
  String description;
  String subredditName;

  public Post(){}

  public Post(int postId, int likes, int dislikes, String postedBy,
              Date postedDate, String title, String description, String subredditName) {
    this.postId = postId;
    this.likes = likes;
    this.dislikes = dislikes;
    this.postedBy = postedBy;
    this.postedDate = postedDate;
    this.title = title;
    this.description = description;
    this.subredditName = subredditName;
  }

  public int getPostId() {
    return postId;
  }

  public void setPostId(int postId) {
    this.postId = postId;
  }

  public int getLikes() {
    return likes;
  }

  public void setLikes(int likes) {
    this.likes = likes;
  }

  public int getDislikes() {
    return dislikes;
  }

  public void setDislikes(int dislikes) {
    this.dislikes = dislikes;
  }

  public String getPostedBy() {
    return postedBy;
  }

  public void setPostedBy(String postedBy) {
    this.postedBy = postedBy;
  }

  public Date getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSubredditName() {
    return subredditName;
  }

  public void setSubredditName(String subredditName) {
    this.subredditName = subredditName;
  }
}
