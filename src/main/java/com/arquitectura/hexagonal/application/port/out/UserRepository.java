package com.arquitectura.hexagonal.application.port.out;

import com.arquitectura.hexagonal.domain.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
    User findById(Long id);
    void deleteById(Long id);
    void updateUser(User user);
}
