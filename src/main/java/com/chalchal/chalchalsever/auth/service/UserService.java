package com.chalchal.chalchalsever.auth.service;

import com.chalchal.chalchalsever.domain.User;
import com.chalchal.chalchalsever.dto.UserRequest;

import java.util.List;

public interface UserService {
    User createUser(UserRequest userRequest);

    User findUser(String email);
    User findUserById(long id);

    User findByEmailAndPassword(String email, String password);

    List<User> findAll();
}
