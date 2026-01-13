package org.josh.climber.DTO.session.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UpdateSessionRequestTO(
        LocalDateTime sessionDate,

        @Min(value = 1, message = "Duration must be at least 1 minute")
        Integer durationMinutes,

        @Size(max = 2000, message = "Notes cannot exceed 2000 characters")
        String notes,

        Long gymId
) {
}
