package com.arquitectura.hexagonal.infrastructure.adapter.out;

import com.arquitectura.hexagonal.application.exception.UserNotFoundException;
import com.arquitectura.hexagonal.application.port.out.UserRepository;
import com.arquitectura.hexagonal.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();
    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User findById(Long id) {
        return users.stream().
                filter(user -> user.id().equals(id)).findFirst().
                orElseThrow(() -> new UserNotFoundException("User with id " + id));
    }

    @Override
    public void deleteById(Long id) {
        var existUser = users.stream().filter(user -> user.id().equals(id)).findFirst();

        if (existUser.isEmpty()) throw new UserNotFoundException("User with id " + id + " not found");

        users.removeIf(user -> user.id().equals(existUser.get().id()));
    }

    @Override
    public void updateUser(User user) {
        var existUser = users.stream().filter(search -> search.id().equals(user.id())).findFirst();

        if (existUser.isEmpty()) throw new UserNotFoundException("User with id " + user.id() + " not found");

        users.removeIf(removeUser -> removeUser.id().equals(existUser.get().id()));

        users.add(user);
    }
}
