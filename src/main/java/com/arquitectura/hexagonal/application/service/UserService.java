package com.arquitectura.hexagonal.application.service;

import com.arquitectura.hexagonal.application.exception.UserNotFoundException;
import com.arquitectura.hexagonal.application.port.in.CreateUserUseCase;
import com.arquitectura.hexagonal.application.port.out.UserRepository;
import com.arquitectura.hexagonal.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements CreateUserUseCase {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name, String email) {
        var user = new User(
                UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE,
                name,
                email);
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id);
    }

    public void updateUser(Long id, String name, String email) {
        var user = new User(id, name, email);
        userRepository.updateUser(user);
    }

    public void deleteUser(Long id) {userRepository.deleteById(id);}
}
