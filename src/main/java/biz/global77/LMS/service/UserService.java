package biz.global77.LMS.service;

import biz.global77.LMS.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void addUser(User user);
    void updateUser(User user);
    void activateUser(int id);
}
