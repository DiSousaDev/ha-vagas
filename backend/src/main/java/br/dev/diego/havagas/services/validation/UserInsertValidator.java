package br.dev.diego.havagas.services.validation;

import br.dev.diego.havagas.controllers.exceptions.FieldMessage;
import br.dev.diego.havagas.entities.User;
import br.dev.diego.havagas.entities.dto.UserInsertDTO;
import br.dev.diego.havagas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void initialize(UserInsertValid ann) {
  }

  @Override
  public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {

    List<FieldMessage> list = new ArrayList<>();

    Optional<User> userOptional = userRepository.findByEmail(dto.getEmail());
    if(userOptional.isPresent()) {
      list.add(new FieldMessage("email", "Email já cadastrado"));
    }

    for (FieldMessage e : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
          .addConstraintViolation();
    }
    return list.isEmpty();
  }
}