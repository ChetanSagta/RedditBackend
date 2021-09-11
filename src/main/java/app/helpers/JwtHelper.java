package app.helpers;

import app.service.MyUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtHelper {

  public static final long JWT_TOKEN_VALIDITY = 10 * 60 * 60 * 24L;
  private static final String SECRET_KEY = "77EF8621BEDE4D435F241CF7E8D249E8CA4F3EFBAA8B2BC58FA25DAF7E520F03";

  @Autowired
  MyUserDetailsService myUserDetailsService;

  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
  }

  public String generateToken(String username) {
    Map<String, Object> claims = new HashMap<>();
    return doGenerateToken(claims, username);
  }

  private String doGenerateToken(Map<String, Object> claims, String subject) {

    return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }

  public Boolean validateToken(String token) {
    final String username = getUsernameFromToken(token);
    myUserDetailsService.loadUserByUsername(username);
    return true;
  }
}
