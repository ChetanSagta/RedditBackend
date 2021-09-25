package app.configurations;

import app.exceptions.AuthenticationHeaderMissingException;
import app.exceptions.InvalidJwtTokenException;
import app.helpers.JwtHelper;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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

  @SneakyThrows
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

    String header = request.getHeader("Authorization");
    log.info("Header : {}", header);
    if (header == null)
      throw new AuthenticationHeaderMissingException("Authentication Header Missing..Please use a valid JWT");
    if (!header.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    String authToken = header.split(" ")[1].trim();
    log.info("Token {} ", authToken);

    UserDetails user = jwtHelper.validateToken(authToken);

    if (user == null) throw new InvalidJwtTokenException("Illegal Token Supplied");

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
    String[] acceptableEndpoints = {"/v1/login/","/v1/signup/","/v1/uniqueUser"};
    String path = request.getRequestURL().substring(21);
    log.info("Path for Filter : " + path);
    for(String endpoint: acceptableEndpoints){
      Pattern pattern = Pattern.compile(endpoint);
      Matcher matcher = pattern.matcher(path);
      if(matcher.matches())  return true;
    }
    return false;
  }
}
