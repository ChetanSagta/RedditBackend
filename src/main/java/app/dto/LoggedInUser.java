package app.dto;

import org.springframework.stereotype.Component;

@Component
public class LoggedInUser {
  ThreadLocal<String> user;

  public LoggedInUser(){
    user = new ThreadLocal<>();
  }

  public void setUser(String user) {
    this.user.set(user);
  }

  public String getUser() {
    return this.user.get();
  }
}
