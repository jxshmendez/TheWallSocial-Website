package org.josh.climber.DTO;

import java.time.LocalDateTime;

public record SessionDTO(
        Long sessionId,
        LocalDateTime sessionDate,
        int durationMinutes,
        String notes,
        LocalDateTime createdAt

) {}
