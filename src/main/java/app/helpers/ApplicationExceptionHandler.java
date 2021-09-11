package app.helpers;

import app.dto.ErrorDTO;
import app.exceptions.EmailAlreadyExist;
import app.exceptions.InvalidCredentialsSupplied;
import app.exceptions.UserAlreadyExists;
import app.exceptions.UserDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

  @ExceptionHandler(UserDoesNotExistException.class)
  public ResponseEntity<ErrorDTO> handleException(UserDoesNotExistException ex){
    ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
    return new ResponseEntity<>(errorDTO,errorDTO.getHttpStatus());
  }

  @ExceptionHandler(EmailAlreadyExist.class)
  public ResponseEntity<ErrorDTO> handleException(EmailAlreadyExist ex){
    ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
    return new ResponseEntity<>(errorDTO,errorDTO.getHttpStatus());
  }

  @ExceptionHandler(UserAlreadyExists.class)
  public ResponseEntity<ErrorDTO> handleException(UserAlreadyExists ex){
    ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
    return new ResponseEntity<>(errorDTO,errorDTO.getHttpStatus());
  }

  @ExceptionHandler(InvalidCredentialsSupplied.class)
  public ResponseEntity<ErrorDTO> handleException(InvalidCredentialsSupplied ex){
    ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
    return new ResponseEntity<>(errorDTO,errorDTO.getHttpStatus());
  }

}
