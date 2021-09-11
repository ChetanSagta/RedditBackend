package app.service;

import app.dto.LoginDTO;
import app.dto.SignUpDTO;
import app.entities.User;
import app.exceptions.EmailAlreadyExist;
import app.exceptions.InvalidCredentialsSupplied;
import app.exceptions.UserAlreadyExists;
import app.helpers.JwtHelper;
import app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {

  @Autowired
  UserRepo userRepo;
  User user;
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  public boolean doesUserExist(String username) {
    user = userRepo.findUserByUsername(username);
    return (user != null);
  }

  public boolean doesEmailExist(String email) {
    user = userRepo.findUserByEmailId(email);
    return (user != null);
  }

  public boolean validatePassword(String password) {
    return bCryptPasswordEncoder.matches(password, user.getPassword());
  }

  public String encodePassword(String password) {
    return bCryptPasswordEncoder.encode(password);
  }

  public void saveUser(User user) {
    userRepo.save(user);
  }


  public String login(LoginDTO loginDTO) throws InvalidCredentialsSupplied {
    String username = loginDTO.getUsername();
    String password = loginDTO.getPassword();
    if (!doesUserExist(username) || !validatePassword(password)) {
      throw new InvalidCredentialsSupplied("Invalid Username or Password");
    }
    JwtHelper jwtHelper = new JwtHelper();
    return jwtHelper.generateToken(loginDTO.getUsername());
  }

  public String signup(SignUpDTO signupDTO) throws UserAlreadyExists, EmailAlreadyExist {
    String username = signupDTO.getUsername();
    String email = signupDTO.getEmail();
    if (doesEmailExist(email)) {
      throw new EmailAlreadyExist("Email already present");
    }
    if (doesUserExist(username)) {
      throw new UserAlreadyExists("User already present");
    }
    User user = new User();
    user.setAdmin(false);
    user.setUsername(signupDTO.getUsername());
    user.setPassword(encodePassword(signupDTO.getPassword()));
    user.setAvatar(signupDTO.getAvatar());
    user.setCreatedOn(new Date());
    user.setEmailId(signupDTO.getEmail());
    userRepo.save(user);
    JwtHelper jwtHelper = new JwtHelper();
    return jwtHelper.generateToken(signupDTO.getUsername());
  }


}
