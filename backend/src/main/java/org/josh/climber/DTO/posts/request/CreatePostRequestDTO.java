package org.josh.climber.DTO.posts.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.josh.climber.model.posts.MediaType;
import org.josh.climber.model.posts.Visibility;

import java.util.List;

public record CreatePostRequestDTO(
        @NotBlank @Size(max = 2200, message = "Caption cannot exceed 2200 characters")
        String caption,

        @NotNull
        Visibility visibility,

        // Media (can be multiple)
        List<MediaItemDTO> media,

        // Associations
        Long sessionId,
        Long routeId,

        // Tags for discoverability
        List<String> tags
) {}

// Supporting DTO for media
record MediaItemDTO(
        @NotBlank
        String mediaUrl,

        String thumbnailUrl,

        @NotNull
        MediaType mediaType  // IMAGE, VIDEO, etc.
) {}