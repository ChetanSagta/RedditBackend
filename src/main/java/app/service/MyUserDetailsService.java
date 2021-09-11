package app.service;

import app.dto.UserPrinciple;
import app.entities.User;
import app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepo.findUserByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("userName Doesn't exist", new Throwable());
    }
    return new UserPrinciple(user);
  }
}
