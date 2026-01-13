package org.josh.climber.DTO.gym.response;

import jakarta.validation.constraints.NotBlank;

public record GymDetailDTO(
        Long gymId,
        @NotBlank String name,
        @NotBlank String location
) {}
