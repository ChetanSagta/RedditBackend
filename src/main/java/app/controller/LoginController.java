package app.controller;

import app.dto.LoginDTO;
import app.dto.SignUpDTO;
import app.entities.User;
import app.exceptions.EmailAlreadyExist;
import app.exceptions.InvalidCredentialsSupplied;
import app.exceptions.UserAlreadyExists;
import app.helpers.JwtHelper;
import app.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/v1")
@Log4j2
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

  @Autowired
  LoginService loginService;

  @Autowired
  JwtHelper jwtHelper;

  /**
   * @return JwtToken
   */
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginDTO loginDTO) throws InvalidCredentialsSupplied {
    String jwtToken = loginService.login(loginDTO);
    String user = jwtHelper.getUsernameFromToken(jwtToken);
    log.info("Username {}",user);

    HashMap<String,String> userInformation = new HashMap<>();
    userInformation.put("jwtToken",jwtToken);
    userInformation.put("username",user);
    return new ResponseEntity<>(userInformation, HttpStatus.OK);
  }

  @PostMapping("/signup")
  public ResponseEntity signup(@RequestBody SignUpDTO signupDTO) throws UserAlreadyExists, EmailAlreadyExist {
    log.info("SignUpDto {}", signupDTO);
    User signedInUser = loginService.signup(signupDTO);
    if(signedInUser!=null){
      return new ResponseEntity<>("User Signed Up Successfully",HttpStatus.OK);
    }
    return new ResponseEntity<>("Couldn't Sign You Up", HttpStatus.EXPECTATION_FAILED);
  }

  @PostMapping("/uniqueUser")
  public boolean isUniqueUser(@RequestBody String user){
    log.info("User " + user);
    return !loginService.doesUserExist(user);
  }

}
