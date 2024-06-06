package com.metrics.metric.entities;

import lombok.*;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Base{

    private Long userId;
    private String username;
    private String email;
    @Transient
    private String password;
    private String fullName;
    private String bio;
    private String profilePictureUrl;
}
