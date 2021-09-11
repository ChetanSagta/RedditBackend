package app.controller;

import app.dto.LoginDTO;
import app.dto.SignUpDTO;
import app.exceptions.EmailAlreadyExist;
import app.exceptions.InvalidCredentialsSupplied;
import app.exceptions.UserAlreadyExists;
import app.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Log4j2
public class LoginController {

  @Autowired
  LoginService loginService;

  /**
   * @return JwtToken
   */
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginDTO loginDTO) throws InvalidCredentialsSupplied {
    String jwtToken = loginService.login(loginDTO);
    return new ResponseEntity<>(jwtToken, HttpStatus.OK);
  }

  @PostMapping("/signup")
  public ResponseEntity signup(@RequestBody SignUpDTO signupDTO) throws UserAlreadyExists, EmailAlreadyExist {
    String jwtToken = loginService.signup(signupDTO);
    return new ResponseEntity<>(jwtToken,HttpStatus.OK);
  }

}
