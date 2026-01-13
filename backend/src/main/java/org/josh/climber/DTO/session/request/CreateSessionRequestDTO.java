package org.josh.climber.DTO.session.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CreateSessionRequestDTO(
        @NotNull(message = "Session date is required")
        LocalDateTime sessionDate,

        @NotNull(message = "Duration is required")
        @Min(value = 1, message = "Duration must be longer than 1 minute")
        Integer durationMinutes,

        @Size(max = 2000, message = "Notes cannot exceed 2000 characters")
        String notes,

        @NotNull(message = "Gym ID is required")
        Long gymId
) {
}
