package org.josh.climber.DTO.posts.response;

import org.josh.climber.DTO.session.response.SessionPreviewDTO;
import org.josh.climber.DTO.route.response.RoutePreviewDTO;
import org.josh.climber.model.posts.MediaType;
import org.josh.climber.model.posts.Visibility;

import java.time.LocalDateTime;

public record PostSummaryDTO(
        Long postId,
        String caption,
        Visibility visibility,
        LocalDateTime createdAt,

        // Media preview (first image/thumbnail)
        String mediaPreviewUrl,
        MediaType primaryMediaType,

        // Author info
        Long authorId,
        String authorUsername,
        String authorAvatarUrl,

        // Session context
        SessionPreviewDTO session,

        // Route context
        RoutePreviewDTO route,

        // Engagement stats
        Integer likeCount,
        Integer commentCount,

        // Quick indicators
        Boolean hasVideo,
        Boolean hasMultipleMedia,
        Boolean isLikedByCurrentUser  
) {}