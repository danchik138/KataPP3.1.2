package com.ex.kata312.service;

import com.ex.kata312.model.User;

import java.util.List;

public interface UserService {

    User getUserById(long id);
    List<User> getAllUsers();

    void addUser(User user);

    void deleteAllUsers();

    void updateUser(User user);

    void deleteUserById(long id);
}
