package app.exceptions;

public class InvalidJwtTokenException extends Exception{
  public InvalidJwtTokenException(String message){
    super(message);
  }
}
