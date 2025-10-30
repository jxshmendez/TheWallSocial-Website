package org.josh.climber.DTO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RouteDTO(
        Long routeId,
        String name,
        @NotBlank String grade,
        String style,
        String setter,
        LocalDateTime createdAt
) {}
