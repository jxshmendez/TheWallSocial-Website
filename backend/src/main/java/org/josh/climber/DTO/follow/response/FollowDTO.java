package org.josh.climber.DTO.follow.response;

import java.time.LocalDateTime;

public record FollowDTO(
        Long followId,
        Long followerId,
        String followerUsername,
        Long followingId,
        String followingUsername,
        LocalDateTime createdAt
) {}
