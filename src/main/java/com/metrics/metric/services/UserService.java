package com.metrics.metric.services;

import com.metrics.metric.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public  UserService(){}

    public User createUser(User user) {
        return  new User();
    }
}
