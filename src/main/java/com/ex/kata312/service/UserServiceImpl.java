package com.ex.kata312.service;

import com.ex.kata312.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ex.kata312.model.User;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Transactional
    @Override
    public void updateUser(User user){
        if (user.getId() != 0 && userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getReferenceById(id);
    }
    @Transactional
    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
