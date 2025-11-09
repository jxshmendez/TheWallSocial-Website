package org.josh.climber.DTO.posts;

import org.josh.climber.model.posts.Visibility;

import java.time.LocalDateTime;

public record PostDTO(
        Long postId,
        String caption,
        Visibility visibility,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long userId,
        String username,
        Long routeId,
        String routeName,
        Long sessionId
) {}
