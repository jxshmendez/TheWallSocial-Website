package org.josh.climber.DTO.attempt.response;

import jakarta.validation.constraints.NotBlank;
import org.josh.climber.model.ResultType;

public record AttemptResponseDTO(
        Long attemptId,
        int attemptTime,
        String notes,
        @NotBlank ResultType result
) {}
