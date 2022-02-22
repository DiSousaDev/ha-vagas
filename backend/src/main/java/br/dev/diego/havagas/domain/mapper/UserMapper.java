package br.dev.diego.havagas.domain.mapper;

import br.dev.diego.havagas.domain.dto.UserDTO;
import br.dev.diego.havagas.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDto(User user);

}
