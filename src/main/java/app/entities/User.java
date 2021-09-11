package app.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int userId;
  String username;
  String emailId;
  String password;
  @Lob
  byte[] avatar;
  Date createdOn;
  boolean isAdmin;
}
