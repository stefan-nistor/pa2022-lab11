package ro.info.uaic.ro.pa2022lab11.services;

import ro.info.uaic.ro.pa2022lab11.dtos.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO user);
    UserDTO findById(Long id);
    List<UserDTO> findAll();
}
