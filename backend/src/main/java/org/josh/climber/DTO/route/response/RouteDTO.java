package org.josh.climber.DTO.route.response;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RouteDTO(
        Long routeId,
        String name,
        Boolean isOutdoor,
        @NotBlank String grade,
        String style,
        String setter,
        LocalDateTime createdAt
) {}
