package org.josh.climber.DTO;

import java.time.LocalDateTime;

public record UserDTO(
        Long userId,
        String username,
        String email,
        String avatarUrl,
        String bio,
        LocalDateTime createdAt

) {}
