package com.arquitectura.hexagonal.infrastructure.adapter.in;

import com.arquitectura.hexagonal.application.exception.UserNotFoundException;
import com.arquitectura.hexagonal.application.port.in.CreateUserUseCase;
import com.arquitectura.hexagonal.application.service.UserService;
import com.arquitectura.hexagonal.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserService userService;

    public UserController(CreateUserUseCase createUserUseCase, UserService userService) {
        this.createUserUseCase = createUserUseCase;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam String email){
        var user = createUserUseCase.createUser(name,email);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        var users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        var user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestParam String name, @RequestParam String email){
        userService.updateUser(id,name,email);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
