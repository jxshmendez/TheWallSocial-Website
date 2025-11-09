package org.josh.climber.DTO.posts;

import org.josh.climber.model.posts.MediaType;

public record MediaDTO(
        Long mediaId,
        MediaType media,
        String mediaUrl,
        String thumbnailUrl
) {}
