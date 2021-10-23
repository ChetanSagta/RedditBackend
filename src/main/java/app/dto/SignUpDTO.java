package app.dto;

import lombok.Data;

@Data
public class SignUpDTO {

  private String username;
  private String email;
  private String password;
  private byte[] avatar;

}
