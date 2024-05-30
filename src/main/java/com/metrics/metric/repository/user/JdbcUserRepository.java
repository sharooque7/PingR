package com.metrics.metric.repository.user;

import com.metrics.metric.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class JdbcUserRepository implements UserRepository{
    private  final JdbcTemplate jdbcTemplate;
    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void insert(User user) {
        String sql = "INSERT INTO users ( username, email, password_hash, full_name, bio, profile_picture_url, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,(PreparedStatement ps)->{
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, user.getFullName());
            ps.setString(5, user.getBio());
            ps.setString(6, user.getProfilePictureUrl());
            ps.setObject(7, user.getCreatedAt());
        });
    }
}
