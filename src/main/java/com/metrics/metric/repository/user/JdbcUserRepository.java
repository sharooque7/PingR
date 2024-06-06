package com.metrics.metric.repository.user;

import com.metrics.metric.entities.User;
import com.metrics.metric.mapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class JdbcUserRepository implements UserRepository{
    private  final JdbcTemplate jdbcTemplate;
    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public User insert(User user) {
        String sql = "INSERT INTO users ( username, email, password_hash, full_name, bio, profile_picture_url) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getFullName());
            ps.setString(5, user.getBio());
            ps.setString(6, user.getProfilePictureUrl());
            return ps;
        }, keyHolder);
        // Set the generated user ID back to the user object
        if (keyHolder.getKeys() != null) {
            user.setUserId(((Integer) Objects.requireNonNull(keyHolder.getKeys()).get("user_id")).longValue());
        }

        return user;
    }

    @Override
    public User findByUserName(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(),new Object[]{username});
    }
}
