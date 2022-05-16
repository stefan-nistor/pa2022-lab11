package ro.info.uaic.ro.pa2022lab11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.info.uaic.ro.pa2022lab11.dtos.UserDTO;
import ro.info.uaic.ro.pa2022lab11.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
