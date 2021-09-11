package app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class ErrorDTO {
  private final HttpStatus httpStatus;
  private final String message;
}
