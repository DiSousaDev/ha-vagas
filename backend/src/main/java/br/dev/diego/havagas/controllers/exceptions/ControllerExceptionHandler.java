package br.dev.diego.havagas.controllers.exceptions;

import br.dev.diego.havagas.services.exceptions.DatabaseException;
import br.dev.diego.havagas.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static java.time.Instant.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<br.dev.diego.havagas.controllers.exceptions.StandardError> entityNotFound(
      ResourceNotFoundException e, HttpServletRequest request) {
    HttpStatus status = NOT_FOUND;

    br.dev.diego.havagas.controllers.exceptions.StandardError err = new br.dev.diego.havagas.controllers.exceptions.StandardError();
    err.setTimestamp(now());
    err.setStatus(status.value());
    err.setError("Resource not found");
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return status(status).body(err);
  }

  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<StandardError> badRequest(DatabaseException e, HttpServletRequest request) {
    HttpStatus status = BAD_REQUEST;
    StandardError err = new StandardError();
    err.setTimestamp(now());
    err.setStatus(status.value());
    err.setError("Database exception");
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return status(status).body(err);
  }

}
