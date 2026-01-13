package org.josh.climber.DTO.session.response;

import java.time.LocalDateTime;

public record SessionDTO(
        Long sessionId,
        LocalDateTime sessionDate,
        Integer durationMinutes,
        String notes,
        LocalDateTime createdAt
) {}
