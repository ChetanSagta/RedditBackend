package app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.OK)
public class EmailAlreadyExist extends Exception {
  public EmailAlreadyExist(String message) {
    super(message);
  }
}
