package ru.javamentor.java.preproject311.service;


import ru.javamentor.java.preproject311.model.User;

import java.util.List;

public interface UserService {
    void saveUser (User user);
    void removeUser (int id);
    List<User> getAllUsers();
    User getUserById (int id);
    void updateUser (int id, User updateUser);
}
