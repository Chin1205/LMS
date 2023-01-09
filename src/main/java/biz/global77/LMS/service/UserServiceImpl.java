package biz.global77.LMS.service;

import biz.global77.LMS.model.User;
import biz.global77.LMS.repository.UserRepository;
import biz.global77.LMS.controller.ResourceNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{

   private final UserRepository userRepository;

    public UserServiceImpl(UserRepository courseRepository) {
        this.userRepository = courseRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void activateUser(int id) {
        User user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        user.setDeactivated(true);
        userRepository.save(user);
    }

}
