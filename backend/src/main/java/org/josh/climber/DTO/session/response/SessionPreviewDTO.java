package org.josh.climber.DTO.session.response;

import java.time.LocalDateTime;

public record SessionPreviewDTO(
        Long sessionId,
        LocalDateTime sessionDate,
        Integer durationMinutes
) {}
