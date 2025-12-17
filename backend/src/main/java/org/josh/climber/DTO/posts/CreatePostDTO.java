package org.josh.climber.DTO.posts;

import org.josh.climber.model.posts.Visibility;

public record CreatePostDTO(
        String caption,
        Visibility visibility,
        Long routeId,
        Long sessionId
) {}
