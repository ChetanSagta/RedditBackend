package app.dto;

import lombok.Data;

@Data
public class SignUpDTO {

  String username;
  String email;
  String password;
  byte[] avatar;

}
