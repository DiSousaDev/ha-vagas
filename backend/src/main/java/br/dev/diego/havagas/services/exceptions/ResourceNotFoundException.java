package br.dev.diego.havagas.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

  public ResourceNotFoundException(String message) {
    super(message);
  }

}
