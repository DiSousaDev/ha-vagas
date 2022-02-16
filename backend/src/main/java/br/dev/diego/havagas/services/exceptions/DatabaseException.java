package br.dev.diego.havagas.services.exceptions;

public class DatabaseException extends RuntimeException{

  public DatabaseException(String message) {
    super(message);
  }

}
