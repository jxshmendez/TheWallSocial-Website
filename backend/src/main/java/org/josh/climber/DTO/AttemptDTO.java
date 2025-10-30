package org.josh.climber.DTO;

import jakarta.validation.constraints.NotBlank;
import org.josh.climber.model.ResultType;

public record AttemptDTO(
        Long attemptId,
        int attemptTime,
        String notes,
        @NotBlank ResultType result
) {}
