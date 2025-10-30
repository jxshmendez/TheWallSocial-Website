package org.josh.climber.DTO;

import jakarta.validation.constraints.NotBlank;

public record GymDTO(
        Long gymId,
        @NotBlank String name,
        @NotBlank String location
) {}
