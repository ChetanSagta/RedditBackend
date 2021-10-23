package app.configurations;

import app.dto.LoggedInUser;
import app.exceptions.AuthenticationHeaderMissingException;
import app.helpers.JwtHelper;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
@Component
public class JwtFilter extends OncePerRequestFilter {

  @Autowired
  JwtHelper jwtHelper;

  @Autowired
  LoggedInUser loggedInUser;

  @SneakyThrows
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

    UserDetails user = null;
    String header = request.getHeader("Authorization");
    if (header == null)
      throw new AuthenticationHeaderMissingException("Authentication Header Missing..Please use a valid JWT");
    if (!header.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    String authToken = header.split(" ")[1].trim();

    try{
      user = jwtHelper.validateToken(authToken);
      loggedInUser.setUser(user.getUsername());
    }
    catch(ExpiredJwtException e){
      //Todo: Fix this
      response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token is Expired");
      return ;
    }

    if (user == null) response.sendError(HttpStatus.UNAUTHORIZED.value(),"Illegal Token Supplied");

    if (user.isEnabled()) {
      filterChain.doFilter(request, response);
      return;
    }

    UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(), Collections.emptyList());
    passwordAuthenticationToken.setAuthenticated(true);
    filterChain.doFilter(request, response);
  }

  @Override
  public boolean shouldNotFilter(HttpServletRequest request){
    String[] acceptableEndpoints = {"/v1/login","/v1/signup","/v1/uniqueUser"};
    String path = request.getRequestURL().substring(21);
    for(String endpoint: acceptableEndpoints){
      Pattern pattern = Pattern.compile(endpoint);
      Matcher matcher = pattern.matcher(path);
      if(matcher.matches())  return true;
    }
    return false;
  }
}
