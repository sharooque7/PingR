package com.metrics.metric.services;

import com.metrics.metric.entities.User;
import com.metrics.metric.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        this.userRepository.insert(user);
    }
}
