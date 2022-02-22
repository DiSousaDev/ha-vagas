package br.dev.diego.havagas.services.validation;

import br.dev.diego.havagas.controllers.exceptions.FieldMessage;
import br.dev.diego.havagas.entities.User;
import br.dev.diego.havagas.domain.dto.UserUpdateDTO;
import br.dev.diego.havagas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  HttpServletRequest httpServletRequest;

  @Override
  public void initialize(UserUpdateValid ann) {
  }

  @Override
  public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

    var uriVars = (Map<String, String>) httpServletRequest.getAttribute(
        HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

    Long userId = Long.parseLong(uriVars.get("id"));

    List<FieldMessage> list = new ArrayList<>();

    Optional<User> userOptional = userRepository.findByEmail(dto.getEmail());
    if(userOptional.isPresent() && !userId.equals(userOptional.get().getId())) {
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