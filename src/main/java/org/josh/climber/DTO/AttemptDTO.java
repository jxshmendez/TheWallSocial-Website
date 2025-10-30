package org.josh.climber.DTO;

import org.josh.climber.model.ResultType;

public record AttemptDTO(
        Long attemptId,
        int attemptTime,
        String notes,
        ResultType result
) {}
