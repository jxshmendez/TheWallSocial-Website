package org.josh.climber.DTO.posts.response;

import org.josh.climber.model.posts.MediaType;

public record MediaDTO(
        Long mediaId,
        MediaType mediaType,
        String mediaUrl,
        String thumbnailUrl
) {}
