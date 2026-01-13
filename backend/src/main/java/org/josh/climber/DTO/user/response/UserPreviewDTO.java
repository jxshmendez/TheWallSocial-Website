package org.josh.climber.DTO.user.response;

public record UserPreviewDTO(
        Long userId,
        String username,
        String bio,
        String avatarUrl,
        Integer followingCount,
        Integer followerCount
){}
