package com.ex.kata312.dao;

import com.ex.kata312.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteAllUsers();

    void updateUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);
}
