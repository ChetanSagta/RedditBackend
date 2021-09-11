package app.exceptions;

public class InvalidCredentialsSupplied extends Throwable {
  public InvalidCredentialsSupplied(String message) {
    super(message);
  }
}
