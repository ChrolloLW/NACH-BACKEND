package pe.nach.config;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleAll(Exception ex, WebRequest req) {
    Map<String, Object> body = Map.of(
      "timestamp", Instant.now().toString(),
      "path", req.getDescription(false),
      "error", ex.getClass().getSimpleName(),
      "message", ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
  }
}
