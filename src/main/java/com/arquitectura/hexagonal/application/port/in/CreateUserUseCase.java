package com.arquitectura.hexagonal.application.port.in;

import com.arquitectura.hexagonal.domain.User;

public interface CreateUserUseCase {
    User createUser(String name, String email);
}
