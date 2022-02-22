package br.dev.diego.havagas.services;

import br.dev.diego.havagas.entities.Role;
import br.dev.diego.havagas.entities.User;
import br.dev.diego.havagas.domain.dto.RoleDTO;
import br.dev.diego.havagas.domain.dto.UserDTO;
import br.dev.diego.havagas.domain.dto.UserInsertDTO;
import br.dev.diego.havagas.domain.dto.UserUpdateDTO;
import br.dev.diego.havagas.repositories.RoleRepository;
import br.dev.diego.havagas.repositories.UserRepository;
import br.dev.diego.havagas.services.exceptions.DatabaseException;
import br.dev.diego.havagas.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Page<UserDTO> findaAllPaged(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserDTO::new);
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User entity = userOptional.orElseThrow(() -> new ResourceNotFoundException("Nenhum usuário encontrado."));
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insert(UserInsertDTO userInsertDTO) {
        User user = new User();
        copyDtoToEntity(userInsertDTO, user);
        user.setPassword(passwordEncoder.encode(userInsertDTO.getPassword()));
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserUpdateDTO userUpdateDTO) {
        try {
            User user = userRepository.getById(id);
            copyDtoToEntity(userUpdateDTO, user);
            user = userRepository.save(user);
            return  new UserDTO(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id [" + id +  "] não encontrado.");
        }
    }

    public void deleteById(Long id){
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id [" + id +  "] não encontrado.");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Id [" + id +  "] não pode ser excluido.");
        }
    }

    private void copyDtoToEntity(UserDTO userDTO, User user){
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        user.getRoles().clear();
        for(RoleDTO roleDTO : userDTO.getRoles()) {
            Role role = roleRepository.getById(roleDTO.getId());
            user.getRoles().add(role);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()) {
            LOG.error(String.format("User not found %s", email));
            throw new UsernameNotFoundException("User not found.");
        }
        LOG.info(String.format("User logged %s", email));
        return user.get();
    }
}
