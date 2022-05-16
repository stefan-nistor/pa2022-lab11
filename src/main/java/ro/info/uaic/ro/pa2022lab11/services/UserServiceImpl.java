package ro.info.uaic.ro.pa2022lab11.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.info.uaic.ro.pa2022lab11.dtos.UserDTO;
import ro.info.uaic.ro.pa2022lab11.entities.UserEntity;
import ro.info.uaic.ro.pa2022lab11.exceptions.UserException;
import ro.info.uaic.ro.pa2022lab11.exceptions.UserNotFoundException;
import ro.info.uaic.ro.pa2022lab11.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDTO saveUser(UserDTO user) {
        var userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb.isPresent())
            throw new UserException("Username Already taken");
        userRepo.save(mapper.map(user, UserEntity.class));
        return user;
    }

    @Override
    public UserDTO findById(Long id) {
        var userFromDb = userRepo.findById(id);
        if(userFromDb.isEmpty())
            throw new UserNotFoundException("No such id");
        return mapper.map(userFromDb.get(), UserDTO.class);
    }
}
