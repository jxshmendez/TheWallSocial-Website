package org.josh.climber.DTO.posts.request;

import jakarta.validation.constraints.Size;
import org.josh.climber.model.posts.Visibility;

import java.util.List;

public record UpdatePostRequestDTO(
        @Size(max = 2200, message = "Caption cannot exceed 2200 characters")
        String caption,

        Visibility visibility,

        // Can update media (add/remove)
        List<MediaItemDTO> mediaToAdd,
        List<Long> mediaIdsToRemove,  // IDs of media to delete

        // Can update associations
        Long routeId,

        // Tags
        List<String> tags

) {}