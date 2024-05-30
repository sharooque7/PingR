package com.metrics.metric.entities;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;
    private String username;
    private String email;
    private String passwordHash;
    private String fullName;
    private String bio;
    private String profilePictureUrl;
    private LocalDateTime createdAt;

}
