package com.metrics.metric.repository.user;

import com.metrics.metric.entities.User;

public interface UserRepository {

    User insert(User user);
    User findByUserName(String username);
}
