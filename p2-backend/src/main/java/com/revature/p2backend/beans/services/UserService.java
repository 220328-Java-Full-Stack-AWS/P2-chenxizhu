package com.revature.p2backend.beans.services;

import com.revature.p2backend.beans.repositories.UserRepository;
import com.revature.p2backend.entities.User;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer save(User user) {
        if (!userRepository.isUsernameUnique(user.getUsername())) {
            return 1;
        }
        else if (!userRepository.isUserEmailUnique(user.getEmail())) {
            return 2;
        }
        else {
            userRepository.save(user);
            return 0;
        }
    }

    public User getUserByUserId(User u) {
        return userRepository.getById(u.getId());
    }
}
