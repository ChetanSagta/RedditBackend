package app.exceptions;

public class AuthenticationHeaderMissingException extends Exception{
  public AuthenticationHeaderMissingException(String message) {
    super(message);
  }
}
