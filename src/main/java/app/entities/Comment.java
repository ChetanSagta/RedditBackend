package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comment {

  int postId;
  int parentCommentId;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int commentId;
  String commentMsg;
  int likes;
  int dislikes;
  String commentedBy;
  Date commentedOn;
  Date updatedOn;

  public Comment(int postId, int parentCommentId, int commentId, String commentMsg, int likes,
                 int dislikes, String commentedBy, Date commentedOn, Date updatedOn) {
    this.postId = postId;
    this.parentCommentId = parentCommentId;
    this.commentId = commentId;
    this.commentMsg = commentMsg;
    this.likes = likes;
    this.dislikes = dislikes;
    this.commentedBy = commentedBy;
    this.commentedOn = commentedOn;
    this.updatedOn = updatedOn;
  }

  public Comment(){}

  public int getPostId() {
    return postId;
  }

  public void setPostId(int postId) {
    this.postId = postId;
  }

  public int getParentCommentId() {
    return parentCommentId;
  }

  public void setParentCommentId(int parentCommentId) {
    this.parentCommentId = parentCommentId;
  }

  public int getCommentId() {
    return commentId;
  }

  public void setCommentId(int commentId) {
    this.commentId = commentId;
  }

  public String getCommentMsg() {
    return commentMsg;
  }

  public void setCommentMsg(String commentMsg) {
    this.commentMsg = commentMsg;
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

  public String getCommentedBy() {
    return commentedBy;
  }

  public void setCommentedBy(String commentedBy) {
    this.commentedBy = commentedBy;
  }

  public Date getCommentedOn() {
    return commentedOn;
  }

  public void setCommentedOn(Date commentedOn) {
    this.commentedOn = commentedOn;
  }

  public Date getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
  }
}
